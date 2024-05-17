package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.dto.RunningStatusDTO;
import se.kth.iv1350.saleprocess.loggers.ExceptionLogger;
import se.kth.iv1350.saleprocess.loggers.TotalRevenueFileOutput;
import se.kth.iv1350.saleprocess.util.PriceUtilities;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        controller.registerObserver(new TotalRevenueView());
        controller.registerObserver(new TotalRevenueFileOutput());
    }


    /**
     * Declares sale's beginning. Sale object is created in this step.
     */
    public void startSale(){
        controller.startSale();
        System.out.println("A new sale has started.");
        System.out.println("-----------------------------------------");
    }

    /**
     * Scans one item and registers it with quantity 1
     * @param itemID Item's identification
     */
    public void scanOneItem(String itemID) {
        try {
            RunningStatusDTO status = controller.registerItems(itemID, 1);
            System.out.println("Running total: " + PriceUtilities.formatPrice(status.getRunningTotal()));
            System.out.println("You added new item to sale!");
            System.out.println(status.getItemDescription());
            System.out.println("It costs: " + PriceUtilities.formatPrice(status.getItemPrice()));
            System.out.println("-----------------------------------------");
        } catch(Exception e) {
            // For users
            System.out.println("Error: " + e.getMessage());
            // For developers
            ExceptionLogger.getInstance().logException(e);
        }
    }

    /**
     * Declares sale's end. SaleInfo object is created in this step.
     */
    public void endSale(){
        int total = controller.endSale();
        System.out.println("Sale has ended with total price of " + PriceUtilities.formatPrice(total) + " kr.");
        System.out.println("-----------------------------------------");
    }

    public void requestDiscount(String customerID){
        int postDiscountTotal = controller.requestDiscount(customerID);
        System.out.println("Discounts were applied, new price: " + PriceUtilities.formatPrice(postDiscountTotal) + " kr.");
        System.out.println("-----------------------------------------");
    }

    /**
     * Registers payment, i.e. finilizes the sale 
     * @param amount Amount paid
     */
    public void registerPayment(int amount){  
        int change = controller.registerPayment(amount);
        System.out.println("Customer paid " + PriceUtilities.formatPrice(amount) + " kr, change is " + PriceUtilities.formatPrice(change) + " kr.");
        System.out.println("-----------------------------------------");
    }


}