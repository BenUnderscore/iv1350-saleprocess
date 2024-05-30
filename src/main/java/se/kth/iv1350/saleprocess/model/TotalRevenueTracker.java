package se.kth.iv1350.saleprocess.model;

import java.util.ArrayList;

/**
 * Stores total revenue of the Point of Sale
 */
public class TotalRevenueTracker {
    private int totalRevenue;

    private ArrayList<TotalRevenueObserver> observers;

    public TotalRevenueTracker(){
        totalRevenue = 0;
        observers = new ArrayList<TotalRevenueObserver>();
    }

    /**
     * @return total revenue
     */
    public int getRevenue(){
        return this.totalRevenue;
    }

    /**
     * Adds income of a sale to the total revenue
     * @param income income of the latest sale
     */
    public void addRevenue(int income){
        totalRevenue += income;

        for(TotalRevenueObserver observer : observers) {
            observer.onTotalRevenueChanged(totalRevenue);
        }
    }

    /**
     * Registers an observer that gets invoked when a the total revenue changes.
     * @param observer The observer to be invoked
     */
    public void registerObserver(TotalRevenueObserver observer) {
        observers.add(observer);
    }
}
