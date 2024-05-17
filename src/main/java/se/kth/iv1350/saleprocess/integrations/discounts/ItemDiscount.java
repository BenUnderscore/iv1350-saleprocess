package se.kth.iv1350.saleprocess.integrations.discounts;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

class ItemDiscount implements Discount {
    private String itemId;
    private int discountPercentage;

    public ItemDiscount(String itemId, int discountPercentage) {
        this.itemId = itemId;
        this.discountPercentage = discountPercentage;
    }

    public int getDiscount(String customerID, int total, ItemInfoDTO[] itemList) {
        int discountTotal = 0;

        for(ItemInfoDTO itemInfo : itemList) {
            if(itemInfo.getId().equals(itemId)) {
                int itemInfoPrice = (itemInfo.getPrice() * itemInfo.getQuantity());
                discountTotal += (itemInfoPrice * discountPercentage) / 100;
            }
        }

        return discountTotal;
    }
}