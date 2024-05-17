package se.kth.iv1350.saleprocess.integrations.discounts;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

interface Discount {
    int getDiscount(String customerID, int total, ItemInfoDTO[] itemList);
}