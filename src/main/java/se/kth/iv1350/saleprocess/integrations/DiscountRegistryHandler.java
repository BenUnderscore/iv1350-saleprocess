package se.kth.iv1350.saleprocess.integrations;

import java.util.ArrayList;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

public class DiscountRegistryHandler {
    public DiscountRegistryHandler() {
        
    }

    /**
     * Fetches eligible discounts from an external registry
     * @param customerID Customer's identification
     * @param total Total price of customer's sale
     * @param itemList Full item list of the sale
     * @return Plain amount reduced with eligible discounts
     */
    public int getDiscount(String customerID, int total, ArrayList<ItemInfoDTO> itemList) {
        return 0;
    }
}
