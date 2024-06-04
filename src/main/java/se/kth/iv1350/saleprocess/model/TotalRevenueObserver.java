package se.kth.iv1350.saleprocess.model;

public abstract class TotalRevenueObserver {
    /**
     * Informs the observer of a new total revenue
     * @param newTotalRevenue The new total revenue
    */
    public final void onTotalRevenueChanged(int newTotalRevenue){
        storeTotalRevenue(newTotalRevenue);
        showTotalIncome();
    }

    private int totalRevenue;

    protected final void storeTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    protected final int getTotalRevenue() {
        return totalRevenue;
    }

    private void showTotalIncome(){
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        } 
    }

    protected abstract void doShowTotalIncome() throws Exception;
    protected abstract void handleErrors(Exception e);


}