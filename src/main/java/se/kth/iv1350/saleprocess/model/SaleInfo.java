package se.kth.iv1350.saleprocess.model;

import java.util.ArrayList;
import java.time.LocalDateTime;

import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.dto.Receipt;

public class SaleInfo {
    private ArrayList<ItemInfo> itemList;
    private int preDiscountPrice;
    private int postDiscountPrice;

    public SaleInfo(ArrayList<ItemInfo> itemList, int totalPrice ){
        this.itemList = itemList;
        this.preDiscountPrice = totalPrice;
    }

    public ArrayList<ItemInfo> getItemList(){
        return itemList;
    }

    public int getPreDiscountPrice() {
        return preDiscountPrice;
    }

    public int getPostDiscountPrice() {
        return postDiscountPrice;
    }

    public Receipt createReceipt(int amountPaid){
        LocalDateTime currentDate = LocalDateTime.now();
        int change = amountPaid - postDiscountPrice;
        Receipt receipt = new Receipt(currentDate, preDiscountPrice, postDiscountPrice, amountPaid, change, itemList);
        return receipt;
    }

    public void applyDiscount(DiscountRegistryHandler DiscountRegistryHandler, String customerID){
        /* Discount logic */
    } 


}
