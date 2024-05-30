package se.kth.iv1350.saleprocess.controller;

import se.kth.iv1350.saleprocess.model.TotalRevenueObserver;

public class FakeObserver implements TotalRevenueObserver {
    private Integer lastObservedTotalRevenue;

    public Integer getLastObservedTotalRevenue() {
        return lastObservedTotalRevenue;
    }

    public void onTotalRevenueChanged(int newTotalRevenue) {
        lastObservedTotalRevenue = Integer.valueOf(newTotalRevenue);
    }
}