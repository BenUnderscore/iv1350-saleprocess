package se.kth.iv1350.saleprocess.dto;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class ReceiptDTO {

    private int preDiscountPrice;
    private int postDiscountPrice;
    private int amountPaid;
    private int change;
    private LocalDateTime dateAndTime;
    private ArrayList<ItemInfoDTO> itemList;
    private int VAT;

    
    public ReceiptDTO(LocalDateTime dateAndTime, int preDiscountPrice, int postDiscountPrice, int amountPaid, int change, ArrayList<ItemInfoDTO> itemList, int VAT){
        this.dateAndTime = dateAndTime;
        this.preDiscountPrice = preDiscountPrice;
        this.postDiscountPrice = postDiscountPrice;
        this.amountPaid = amountPaid;
        this.change = change;
        this.itemList = itemList;
        this.VAT = VAT;
    }

    /** @return Price of all items before discounts are applied */
    public int getPreDiscountPrice() { return this.preDiscountPrice; }
    /** @return Price of all items in a sale after relevant discounts are applied */
    public int getPostDiscountPrice() { return this.postDiscountPrice; }
    /** @return The amount money paid by the customer */
    public int getAmountPaid() { return this.amountPaid; }
    /** @return Difference between amountPaid and postDiscountPrice */
    public int getChange() { return this.change; }
    /** @return Date and time of payment */
    public LocalDateTime getDateAndTime() { return this.dateAndTime; }
    /** @return List of all items in a sale */
    public ArrayList<ItemInfoDTO> getItemList() { return new ArrayList<ItemInfoDTO>(this.itemList); }
    /** @return VAT for the Sale */
    public int getVAT() { return this.VAT; }
}
