package se.kth.iv1350.saleprocess.integrations.discounts;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

public class CustomerDiscountTest {
    @Test
    public void customerMatches() {
        Discount discount = new CustomerDiscount("dante");
        int discountAmount = discount.getDiscount("dante", 1000, new ArrayList<ItemInfoDTO>());
        assertEquals(discountAmount, 100);
    }

    @Test
    public void customerDoesNotMatch() {
        Discount discount = new CustomerDiscount("dante");
        int discountAmount = discount.getDiscount("theCoolerDante", 1000, new ArrayList<ItemInfoDTO>());
        assertEquals(discountAmount, 0);
    }
}