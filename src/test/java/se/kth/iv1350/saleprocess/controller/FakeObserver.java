package se.kth.iv1350.saleprocess.controller;

import se.kth.iv1350.saleprocess.model.TotalRevenueObserver;

public class FakeObserver extends TotalRevenueObserver {
    private Integer lastObservedTotalRevenue;

    public Integer getLastObservedTotalRevenue() {
        return lastObservedTotalRevenue;
    }

    @Override
    protected void doShowTotalIncome() throws Exception {
        lastObservedTotalRevenue = Integer.valueOf(getTotalRevenue());
    }

    @Override
    protected void handleErrors(Exception e) {
        throw new UnsupportedOperationException("Unimplemented method 'handleErrors'");
    }
}