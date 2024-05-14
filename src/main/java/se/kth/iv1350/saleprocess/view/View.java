package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.dto.RunningStatusDTO;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    private static String formatPrice(int amount) {
        return String.format("%01d.%02d", amount / 100, amount % 100);
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
    public void scanOneItem(String itemID){
        RunningStatusDTO status = controller.registerItems(itemID, 1);
        System.out.println("Running total: " + formatPrice(status.getRunningTotal()));
        System.out.println("You added new item to sale!");
        System.out.println(status.getItemDescription());
        System.out.println("It costs: " + formatPrice(status.getItemPrice()));
        System.out.println("-----------------------------------------");
    }

    /**
     * Declares sale's end. SaleInfo object is created in this step.
     */
    public void endSale(){
        int total = controller.endSale();
        System.out.println("Sale has ended with total price of " + formatPrice(total) + " kr.");
        System.out.println("-----------------------------------------");
    }

    /**
     * Registers payment, i.e. finilizes the sale 
     * @param amount Amount paid
     */
    public void registerPayment(int amount){  
        int change = controller.registerPayment(amount);
        System.out.println("Customer paid " + formatPrice(amount) + " kr, change is " + formatPrice(change) + " kr.");
        System.out.println("-----------------------------------------");
    }


}