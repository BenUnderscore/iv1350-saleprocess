package se.kth.iv1350.saleprocess.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.dto.ReceiptDTO;

public class SaleInfoTest {
    public SaleInfoTest() {

    }

    @Test
    public void createReceiptTest(){

        ItemInfoDTO[] itemList = new ItemInfoDTO[] {
            new ItemInfoDTO("VeryCoolPatch", "A patch that is very cool", "69nice", 6990, 5, 1),
            new ItemInfoDTO("The Key", "Refreshing mocktail", "666key", 3050, 12, 10),
            new ItemInfoDTO("Dragon Breath", "Hot lingering dragon breath", "420oof", 42060, 20, 1),
            new ItemInfoDTO("Spaceship Engine", "Very powerful, makes amazing spaceship noises", "w0o0sh", 102500, 25, 1)
        };

        int discount = 666;
        int total = 69 + 30 * 10 + 420 + 1025;
        int vat = 0;
        for(ItemInfoDTO item : itemList) {
            vat += (item.getPrice() * item.getQuantity()) * item.getVat() / 100;
        }

        int paid = 5000;
        int postDiscountPrice = total - discount;
        int change = paid - postDiscountPrice;
        LocalDateTime currentDate = LocalDateTime.now();
        
        SaleInfo saleInfo = new SaleInfo(itemList, total);
        
        saleInfo.applyDiscountDummy(discount);
        
        ReceiptDTO receipt = saleInfo.createReceipt(paid);

        long diffTime = currentDate.until(receipt.getDateAndTime(), ChronoUnit.SECONDS);
        
        assertEquals(receipt.getChange(), change);
        assertEquals(receipt.getVAT(), vat);
        assertEquals(receipt.getPreDiscountPrice(), total);
        assertEquals(receipt.getPostDiscountPrice(), postDiscountPrice);
        assertEquals(receipt.getAmountPaid(), paid);
        assertTrue(diffTime < 2);
        assertArrayEquals(receipt.getItemList(), itemList);
    }
}
