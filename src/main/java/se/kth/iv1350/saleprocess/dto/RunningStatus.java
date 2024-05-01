package se.kth.iv1350.saleprocess.dto;

public class RunningStatus {
    /** Current total price for all items in a sale */
    int runningTotal;
    /** Latest item's price including VAT */
    int itemPrice;
    /** Latest item's description */
    String itemDescription;

    public RunningStatus(int runningTotal, int itemPrice, String itemDescription){
        this.runningTotal = runningTotal;
        this.itemPrice = itemPrice;
        this. itemDescription = itemDescription;
    }
}