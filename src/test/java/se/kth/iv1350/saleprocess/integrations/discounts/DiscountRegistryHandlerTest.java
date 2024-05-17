package se.kth.iv1350.saleprocess.integrations.discounts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

public class DiscountRegistryHandlerTest {
    @Test
    public void inExampleData() {
        String customerId = "TheCoolerDante";

        ItemInfoDTO[] items = new ItemInfoDTO[] {
            new ItemInfoDTO(
                "Cool item",
                "cold",
                "def456",
                5000,
                10,
                4
            ),
            new ItemInfoDTO(
                "Cooler item",
                "very cold",
                "fed321",
                10000,
                25,
                1
            )
        };

        int total = 30000;
        
        DiscountRegistryHandler handler = new DiscountRegistryHandler();
        int discountTotal = handler.getDiscount(customerId, total, items);

        assertEquals(4500, discountTotal);
    }

    @Test
    public void notInExampleData() {
        String customerId = "benedek";

        ItemInfoDTO[] items = new ItemInfoDTO[] {
            new ItemInfoDTO(
                "Cool item",
                "cold",
                "def123",
                5000,
                10,
                1
            ),
            new ItemInfoDTO(
                "Cooler item",
                "very cold",
                "fed321",
                10000,
                25,
                1
            )
        };

        int total = 15000;
        
        DiscountRegistryHandler handler = new DiscountRegistryHandler();
        int discountTotal = handler.getDiscount(customerId, total, items);

        assertEquals(0, discountTotal);
    }
}