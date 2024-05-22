package se.kth.iv1350.saleprocess.integrations.discounts;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

public class DiscountRegistryHandlerTest {
    @Test
    public void inExampleData() {
        String customerId = "TheCoolerDante";

        ArrayList<ItemInfoDTO> items = new ArrayList<ItemInfoDTO>();
        items.add(
            new ItemInfoDTO(
                "Cool item",
                "cold",
                "def456",
                5000,
                10,
                4
            )
        );
        items.add(
            new ItemInfoDTO(
                "Cooler item",
                "very cold",
                "fed321",
                10000,
                25,
                1
            )
        );

        int total = 30000;
        
        DiscountRegistryHandler handler = new DiscountRegistryHandler();
        int discountTotal = handler.getDiscount(customerId, total, items);

        assertEquals(4500, discountTotal);
    }

    @Test
    public void notInExampleData() {
        String customerId = "benedek";

        ArrayList<ItemInfoDTO> items = new ArrayList<ItemInfoDTO>();
        items.add(
            new ItemInfoDTO(
                "Cool item",
                "cold",
                "def123",
                5000,
                10,
                1
            )
        );
        items.add(
            new ItemInfoDTO(
                "Cooler item",
                "very cold",
                "fed321",
                10000,
                25,
                1
            )
        );

        int total = 15000;
        
        DiscountRegistryHandler handler = new DiscountRegistryHandler();
        int discountTotal = handler.getDiscount(customerId, total, items);

        assertEquals(0, discountTotal);
    }
}