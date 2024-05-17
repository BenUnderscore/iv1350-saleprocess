package se.kth.iv1350.saleprocess.model;

/**
 * Stores total revenue of the Point of Sale
 */
public class TotalRevenueTracker {
    private int totalRevenue;

    public TotalRevenueTracker(){
        totalRevenue = 0;
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
        this.totalRevenue += income;
    }
}
