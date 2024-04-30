package se.kth.iv1350.saleprocess.startup;

import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import se.kth.iv1350.saleprocess.integrations.AccountingSystemHandler;
import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;
import se.kth.iv1350.saleprocess.integrations.PrinterHandler;
import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.view.View;

public class Program{
    public static void main(){
        System.out.println("Hello, world!");

        startup();
    }

    public static void startup(){
        PrinterHandler printerHandler = new PrinterHandler();
        InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
        DiscountRegistryHandler discountRegistryHandler = new DiscountRegistryHandler();
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        Controller controller = new Controller(printerHandler, inventorySystemHandler, discountRegistryHandler, accountingSystemHandler);
        View view = new View(controller);        
    }
}
