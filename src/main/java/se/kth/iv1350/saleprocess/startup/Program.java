package se.kth.iv1350.saleprocess.startup;

import se.kth.iv1350.saleprocess.integrations.AccountingSystemHandler;
import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;
import se.kth.iv1350.saleprocess.integrations.PrinterHandler;
import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.view.View;

public class Program{
    public static void main(String[] args){
        View view = startup();
    }

    /**
     * Creates integrations objects, view and controller, distributing relevant objects between them.
     * @return View object
     */
    public static View startup(){
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        DiscountRegistryHandler discountRegistryHandler = new DiscountRegistryHandler();
        InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
        PrinterHandler printerHandler = new PrinterHandler();
        Controller controller = new Controller(accountingSystemHandler, discountRegistryHandler, inventorySystemHandler, printerHandler);
        return new View(controller);        
    }
}
