package se.kth.iv1350.saleprocess.integrations.discounts;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ItemDiscountTest {
    @Test
    public void itemMatches() {
        Discount discount = new ItemDiscount("abc123", 10);
        
        ArrayList<ItemInfoDTO> itemInfos = new ArrayList<ItemInfoDTO>();
        itemInfos.add(
            new ItemInfoDTO(
                "Something very nice",
                "very nice",
                "abc123",
                8000,
                10,
                1
            )
        );

        int discountAmount = discount.getDiscount("", 15000, itemInfos);
        assertEquals(800, discountAmount);
    }

    @Test
    public void itemDoesNotMatch() {
        Discount discount = new ItemDiscount("def456", 10);
        
        ArrayList<ItemInfoDTO> itemInfos = new ArrayList<ItemInfoDTO>();
        itemInfos.add(
            new ItemInfoDTO(
                "Something very nice",
                "very nice",
                "abc123",
                8000,
                10,
                1
            )
        );

        int discountAmount = discount.getDiscount("", 15000, itemInfos);
        assertEquals(0, discountAmount);
    }
}