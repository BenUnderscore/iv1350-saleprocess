package se.kth.iv1350.saleprocess.model;

public interface TotalRevenueObserver {
    /**
     * Informs the observer of a new total revenue
     * @param newTotalRevenue The new total revenue
    */
    void onTotalRevenueChanged(int newTotalRevenue);
}
