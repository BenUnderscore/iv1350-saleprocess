package se.kth.iv1350.saleprocess.model;

import java.util.ArrayList;
import java.time.LocalDateTime;

import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.dto.Receipt;

public class SaleInfo {
    private ArrayList<ItemInfo> itemList;
    private int totalPrice;
    private int currentTotal;

    public SaleInfo(ArrayList<ItemInfo> itemList, int totalPrice ){
        this.itemList = itemList;
        this.totalPrice = totalPrice;
    }

    public ArrayList<ItemInfo> getItemList(){
        return itemList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public Receipt createReceipt(int amountPaid){
        LocalDateTime currentDate = LocalDateTime.now();
        int change = amountPaid - currentTotal;
        Receipt receipt = new Receipt(currentDate, totalPrice, currentTotal, amountPaid, change, itemList);
        return receipt;
    }

    public void applyDiscount(DiscountRegistryHandler DiscountRegistryHandler, String customerID){
        /* Discount logic */
    } 
}
