package se.kth.iv1350.saleprocess.integrations.discounts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

public class ThresholdDiscountTest {
    @Test
    public void underThreshold() {
        Discount discount = new ThresholdDiscount(450, 10);
        int discountAmount = discount.getDiscount("", 400, new ItemInfoDTO[0]);
        assertEquals(0, discountAmount);
    }

    @Test
    public void overThreshold() {
        Discount discount = new ThresholdDiscount(450, 10);
        int discountAmount = discount.getDiscount("", 500, new ItemInfoDTO[0]);
        assertEquals(50, discountAmount);
    }
}