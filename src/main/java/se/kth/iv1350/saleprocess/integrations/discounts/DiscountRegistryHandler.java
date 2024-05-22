package se.kth.iv1350.saleprocess.integrations.discounts;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

public class DiscountRegistryHandler {

    private ArrayList<Discount> discounts;
    
    public DiscountRegistryHandler() {
        discounts = new ArrayList<Discount>();

        discounts.add(
            new CustomerDiscount("dante")
        );

        discounts.add(
            new CustomerDiscount("TheCoolerDante")
        );

        discounts.add(
            new ItemDiscount("jkl012", 50)
        );

        discounts.add(
            new ItemDiscount("def456", 10)
        );

        discounts.add(
            new ThresholdDiscount(20000, 15)
        );
    }

    /**
     * Fetches eligible discounts from an external registry
     * @param customerID Customer's identification
     * @param total Total price of customer's sale
     * @param itemList Full item list of the sale
     * @return Amount of discount to apply to the total
     */
    public int getDiscount(String customerID, int total, List<ItemInfoDTO> itemList) {
        int maxDiscount = 0;
        for(Discount discount : discounts) {
            int discounted = discount.getDiscount(customerID, total, itemList);
            maxDiscount = discounted > maxDiscount ? discounted : maxDiscount;
        }

        return maxDiscount;
    }
}
