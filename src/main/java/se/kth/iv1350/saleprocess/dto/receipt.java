package se.kth.iv1350.saleprocess.dto;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Receipt {

    public int initialPrice;
    public int finalPrice;
    public int amountPaid;
    public int change;
    public LocalDateTime date;
    public ArrayList<ItemInfo> itemList;

    /**
     * Creates receipt DTO, with the below params
     * @param date date of payment
     * @param initialPrice price of sale before any discounts are applied
     * @param finalPrice price of sale after relevant discounts are applied, 
     * @param amountPaid the amount paid by the customer
     * @param change the change returned to the customer after paying 
     * @param itemList a list of all items that have been in the purchase
     */
    public Receipt(LocalDateTime date, int initialPrice, int finalPrice, int amountPaid, int change, ArrayList<ItemInfo> itemList){
        this.date = date;
        this.initialPrice = initialPrice;
        this.finalPrice = finalPrice;
        this.amountPaid = amountPaid;
        this.change = change;
        this.itemList = itemList;
    }
}
