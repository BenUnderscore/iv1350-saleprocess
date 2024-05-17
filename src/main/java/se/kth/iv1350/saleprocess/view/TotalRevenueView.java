package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.controller.Observer;

public class TotalRevenueView implements Observer {
    public TotalRevenueView() {
    }

    public void onTotalRevenueChanged(int newTotalRevenue) {
        System.out.print("New total revenue: ");
        System.out.print(newTotalRevenue);
        System.out.print(" SEK");
        System.out.println();
    }
}
