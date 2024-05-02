package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.dto.Receipt;
import se.kth.iv1350.saleprocess.model.SaleInfo;

public class SaleInfoTest {
    public SaleInfoTest() {

    }

    @Test
    public void createReceiptTest(){

        ArrayList<ItemInfo> itemList = new ArrayList<ItemInfo>();
        itemList.add(new ItemInfo("VeryCoolPatch", "A patch that is very cool", "69nice", 6990, 5, 1));
        itemList.add(new ItemInfo("The Key", "Refreshing mocktail", "666key", 3050, 12, 10));
        itemList.add(new ItemInfo("Dragon Breath", "Hot lingering dragon breath", "420oof", 42060, 20, 1));
        itemList.add(new ItemInfo("Spaceship Engine", "Very powerful, makes amazing spaceship noises", "w0o0sh", 102500, 25, 1));

        int discount = 666;
        int total = 69 + 30 * 10 + 420 + 1025;
        int vat = 0;
        for(ItemInfo item : itemList) {
            vat += (item.price * item.quantity) * item.vat / 100;
        }

        int paid = 5000;
        int postDiscountPrice = total - discount;
        int change = paid - postDiscountPrice;
        LocalDateTime currentDate = LocalDateTime.now();
        
        SaleInfo saleInfo = new SaleInfo(itemList, total);
        
        saleInfo.applyDiscountDummy(discount);
        
        Receipt receipt = saleInfo.createReceipt(paid);

        long diffTime = currentDate.until(receipt.dateAndTime, ChronoUnit.SECONDS);
        
        assertEquals(receipt.change, change);
        assertEquals(receipt.VAT, vat);
        assertEquals(receipt.preDiscountPrice, total);
        assertEquals(receipt.postDiscountPrice, postDiscountPrice);
        assertEquals(receipt.amountPaid, paid);
        assertTrue(diffTime < 2);
        assertEquals(receipt.itemList, itemList);

    }
}
