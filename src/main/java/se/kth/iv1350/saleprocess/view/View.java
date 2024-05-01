package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.dto.RunningStatus;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Declares sale's beginning. Sale object is created in this step.
     */
    public void startSale(){
        controller.startSale();
    }

    /**
     * Scans one item and registers it with quantity 1
     * @param itemID Item's identification
     * @return Sale's status: total price, latest item's price and description
     */
    public RunningStatus scanOneItem(String itemID){
        return controller.registerItems(itemID, 1);
    }

    /**
     * Declares sale's end. SaleInfo object is created in this step.
     * @return Total sale's price
     */
    public int endSale(){
        return controller.endSale();
    }

    /**
     * Registers payment, i.e. finilizes the sale 
     * @param amount Amount paid
     * @return Change
     */
    public int registerPayment(int amount){  
        return controller.registerPayment(amount);
    }


}