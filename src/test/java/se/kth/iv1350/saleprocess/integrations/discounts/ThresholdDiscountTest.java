package se.kth.iv1350.saleprocess.integrations.discounts;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

public class ThresholdDiscountTest {
    @Test
    public void underThreshold() {
        Discount discount = new ThresholdDiscount(450, 10);
        int discountAmount = discount.getDiscount("", 400, new ArrayList<ItemInfoDTO>());
        assertEquals(0, discountAmount);
    }

    @Test
    public void overThreshold() {
        Discount discount = new ThresholdDiscount(450, 10);
        int discountAmount = discount.getDiscount("", 500, new ArrayList<ItemInfoDTO>());
        assertEquals(50, discountAmount);
    }
}