package se.kth.iv1350.saleprocess.controller;

import java.util.ArrayList;

import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.dto.Receipt;
import se.kth.iv1350.saleprocess.dto.RunningStatus;
import se.kth.iv1350.saleprocess.integrations.AccountingSystemHandler;
import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;
import se.kth.iv1350.saleprocess.integrations.PrinterHandler;
import se.kth.iv1350.saleprocess.model.Sale;
import se.kth.iv1350.saleprocess.model.SaleInfo;


public class Controller {
    
    // Handlers of external systems
    private AccountingSystemHandler accountingSystemHandler;
    private DiscountRegistryHandler discountRegistryHandler;
    private InventorySystemHandler inventorySystemHandler;
    private PrinterHandler printerHandler;

    // Models
    private SaleInfo saleInfo;
    private Sale sale;
    
    public Controller(AccountingSystemHandler acc, DiscountRegistryHandler disc, InventorySystemHandler inv, PrinterHandler printer){
        accountingSystemHandler = acc;
        discountRegistryHandler = disc;
        inventorySystemHandler = inv;
        printerHandler = printer;
    }

    /**
     * Creates new sale object with an empty item list
     */
    public void startSale(){
        sale = new Sale(new ArrayList<ItemInfo>());
    }

    /**
     * Asks inventory system handler to fetch an item, adds it to the sale and gets total sale price
     * @param itemID Item Identification
     * @param quantity Amount of the same item
     * @return Running sale total price, item's price and item's description
     */
    public RunningStatus registerItems(String itemID, int quantity){
        ItemInfo newItem = inventorySystemHandler.getItem(itemID);

        /* If item ID is not found, throw exception */

        sale.addItems(newItem, quantity);
        int runningtotal = sale.calculateTotal();

        RunningStatus status = new RunningStatus(runningtotal, newItem.price, newItem.description);

        return status;
    }

    /**
     * Finishes sale by asking for a saleInfo object
     * @return Total price
     */
    public int endSale(){
        saleInfo = sale.finalizeSaleInfo();

        int currentTotal = saleInfo.getPostDiscountPrice();

        return currentTotal;
    }

    /**
     * Requests for discount from external system. Currentely is not implemented
     * @param customerID Customer identification
     * @return Discount total
     */
    public int requestDiscount(String customerID){
        saleInfo.applyDiscounts(discountRegistryHandler, customerID);
        return saleInfo.getPostDiscountPrice();
    }

    /**
     * Finalizes process. Asks for receipt, prints it, logs it and updates inventory.
     * @param amountPaid How much customer paid
     * @return Difference between amount paid and total price.
     */
    public int registerPayment(int amountPaid){
        Receipt receipt = saleInfo.createReceipt(amountPaid);
        printerHandler.printReceipt(receipt);
        accountingSystemHandler.logSale(receipt);
        inventorySystemHandler.updateInventory(receipt.itemList);

        return receipt.change;
    }


}
