package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.model.Sale;
import se.kth.iv1350.saleprocess.model.SaleInfo;

public class SaleTest {
    public SaleTest() {}

    private final ItemInfo item1 = new ItemInfo(
        "Item 1",
        "The first item to test",
        "1",
        100,
        25,
        1
    );

    private final ItemInfo item2 = new ItemInfo(
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

        ArrayList<ItemInfo> itemList = saleInfo.getItemList();
        for (ItemInfo itemInfo : itemList) {
            if(itemInfo.id == item1.id) {
                assertEquals(item1.description, itemInfo.description);
                assertEquals(item1.name, itemInfo.name);
                assertEquals(item1.price, itemInfo.price);
                assertEquals(6, itemInfo.quantity);
            } else if(itemInfo.id == item2.id) {
                assertEquals(item2.description, itemInfo.description);
                assertEquals(item2.name, itemInfo.name);
                assertEquals(item2.price, itemInfo.price);
                assertEquals(1, itemInfo.quantity);
            }
        }
    }
}
