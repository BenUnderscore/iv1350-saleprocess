package se.kth.iv1350.saleprocess.integrations.discounts;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ItemDiscountTest {
    @Test
    public void itemMatches() {
        Discount discount = new ItemDiscount("abc123", 10);
        
        ItemInfoDTO itemInfo = new ItemInfoDTO(
            "Something very nice",
            "very nice",
            "abc123",
            8000,
            10,
            1
        );

        int discountAmount = discount.getDiscount("", 15000, new ItemInfoDTO[] { itemInfo });
        assertEquals(800, discountAmount);
    }

    @Test
    public void itemDoesNotMatch() {
        Discount discount = new ItemDiscount("def456", 10);
        
        ItemInfoDTO itemInfo = new ItemInfoDTO(
            "Something very nice",
            "very nice",
            "abc123",
            8000,
            10,
            1
        );

        int discountAmount = discount.getDiscount("", 15000, new ItemInfoDTO[] { itemInfo });
        assertEquals(0, discountAmount);
    }
}