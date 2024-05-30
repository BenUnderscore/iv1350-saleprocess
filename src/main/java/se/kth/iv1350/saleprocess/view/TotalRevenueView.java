package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.model.TotalRevenueObserver;
import se.kth.iv1350.saleprocess.util.PriceUtilities;

public class TotalRevenueView implements TotalRevenueObserver {
    public TotalRevenueView() {
    }

    @Override
    public void onTotalRevenueChanged(int newTotalRevenue) {
        System.out.print("New total revenue: ");
        System.out.print(PriceUtilities.formatPrice(newTotalRevenue));
        System.out.print(" SEK");
        System.out.println();
    }
}
