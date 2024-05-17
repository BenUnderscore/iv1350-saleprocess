package se.kth.iv1350.saleprocess.controller;

public class FakeObserver implements Observer {
    private Integer lastObservedTotalRevenue;

    public Integer getLastObservedTotalRevenue() {
        return lastObservedTotalRevenue;
    }

    public void onTotalRevenueChanged(int newTotalRevenue) {
        lastObservedTotalRevenue = new Integer(newTotalRevenue);
    }
}