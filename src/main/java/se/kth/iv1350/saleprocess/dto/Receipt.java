package se.kth.iv1350.saleprocess.dto;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Receipt {

    /** Price of all items in a sale before any discounts are applied */
    public int preDiscountPrice;
    /** Price of all items in a sale after relevant discounts are applied */
    public int postDiscountPrice;
    /** The amount money paid by the customer */
    public int amountPaid;
    /** Difference between amountPaid and postDiscountPrice */
    public int change;
    /** Date and time of payment */
    public LocalDateTime dateAndTime;
    /** List of all items in a sale */
    public ArrayList<ItemInfo> itemList;
    /** VAT for the Sale */
    public int VAT;

    
    public Receipt(LocalDateTime dateAndTime, int preDiscountPrice, int postDiscountPrice, int amountPaid, int change, ArrayList<ItemInfo> itemList, int VAT){
        this.dateAndTime = dateAndTime;
        this.preDiscountPrice = preDiscountPrice;
        this.postDiscountPrice = postDiscountPrice;
        this.amountPaid = amountPaid;
        this.change = change;
        this.itemList = itemList;
        this.VAT = VAT;
    }
}
