package se.kth.iv1350.saleprocess.integrations.discounts;

import java.util.List;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

class ThresholdDiscount implements Discount {
    private int threshold;
    private int percentage;

    public ThresholdDiscount(int threshold, int percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public int getDiscount(String customerID, int total, List<ItemInfoDTO> itemList) {
        if(total >= threshold) {
            return (total * percentage) / 100;
        }

        return 0;
    }
}