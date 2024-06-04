package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.loggers.ExceptionLogger;
import se.kth.iv1350.saleprocess.model.TotalRevenueObserver;
import se.kth.iv1350.saleprocess.util.PriceUtilities;

public class TotalRevenueView extends TotalRevenueObserver {
    public TotalRevenueView() {
    }

    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.print("New total revenue: ");
        System.out.print(PriceUtilities.formatPrice(getTotalRevenue()));
        System.out.print(" SEK");
        System.out.println();
    }

    @Override
    protected void handleErrors(Exception e) {
        ExceptionLogger.getInstance().logException(e);
    }
}
