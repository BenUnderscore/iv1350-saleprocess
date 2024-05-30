package se.kth.iv1350.saleprocess.integrations.discounts;

import java.util.List;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

interface Discount {
    /**
     * Calculates the plain discounted amount based on bussines rules for the specific discount type
     * @return discounted amount 
     */
    int getDiscount(String customerID, int total, List<ItemInfoDTO> itemList);
}