package se.kth.iv1350.saleprocess.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;


public class SaleTest {
    public SaleTest() {}

    private final ItemInfoDTO item1 = new ItemInfoDTO(
        "Item 1",
        "The first item to test",
        "1",
        100,
        25,
        1
    );

    private final ItemInfoDTO item2 = new ItemInfoDTO(
        "Item 2",
        "The second item to test",
        "2",
        320,
        21,
        1
    );

    @Test
    public void emptySale() {
        Sale sale = new Sale();
        SaleInfo saleInfo = sale.finalizeSaleInfo();

        assertEquals(0, saleInfo.getPreDiscountPrice());
        assertEquals(0, saleInfo.getPostDiscountPrice());
        assertEquals(0, saleInfo.getItemList().size());
    }

    @Test
    public void fullSale() {
        Sale sale = new Sale();

        sale.addItems(item1, 2);
        sale.addItems(item1, 4);
        sale.addItems(item2, 1);

        SaleInfo saleInfo = sale.finalizeSaleInfo();
        assertEquals(920, saleInfo.getPreDiscountPrice());
        assertEquals(920, saleInfo.getPostDiscountPrice());
        assertEquals(2, saleInfo.getItemList().size());

        List<ItemInfoDTO> itemList = saleInfo.getItemList();
        for (ItemInfoDTO itemInfo : itemList) {
            if(itemInfo.getId() == item1.getId()) {
                assertEquals(item1.getDescription(), itemInfo.getDescription());
                assertEquals(item1.getName(), itemInfo.getName());
                assertEquals(item1.getPrice(), itemInfo.getPrice());
                assertEquals(6, itemInfo.getQuantity());
            } else if(itemInfo.getId() == item2.getId()) {
                assertEquals(item2.getDescription(), itemInfo.getDescription());
                assertEquals(item2.getName(), itemInfo.getName());
                assertEquals(item2.getPrice(), itemInfo.getPrice());
                assertEquals( 1, itemInfo.getQuantity());
            }
        }
    }
}
