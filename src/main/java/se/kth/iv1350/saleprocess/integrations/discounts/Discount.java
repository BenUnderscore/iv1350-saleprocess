package se.kth.iv1350.saleprocess.integrations.discounts;

import java.util.List;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

interface Discount {
    int getDiscount(String customerID, int total, List<ItemInfoDTO> itemList);
}