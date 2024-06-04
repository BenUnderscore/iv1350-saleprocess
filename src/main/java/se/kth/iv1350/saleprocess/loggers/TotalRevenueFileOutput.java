package se.kth.iv1350.saleprocess.loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.saleprocess.model.TotalRevenueObserver;
import se.kth.iv1350.saleprocess.util.PriceUtilities;

public class TotalRevenueFileOutput extends TotalRevenueObserver {
    private PrintWriter logStream;

    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("totalrevenuelog.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CANNOT LOG.");
            ioe.printStackTrace();
        }
    }

    @Override
    protected void doShowTotalIncome() throws Exception {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm"));
        logStream.println("[" + dateTime + "] New total revenue: " + PriceUtilities.formatPrice(getTotalRevenue()) + " SEK");
    }

    @Override
    protected void handleErrors(Exception e) {
        ExceptionLogger.getInstance().logException(e);
    }
}