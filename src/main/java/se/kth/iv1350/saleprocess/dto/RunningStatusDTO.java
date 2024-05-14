package se.kth.iv1350.saleprocess.dto;

public class RunningStatusDTO {
    private int runningTotal;
    private int itemPrice;
    private String itemDescription;

    public RunningStatusDTO(int runningTotal, int itemPrice, String itemDescription){
        this.runningTotal = runningTotal;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    /** @return Current total price for all items in a sale */
    public int getRunningTotal() { return this.runningTotal; }
    /** @return Latest item's price including VAT */
    public int getItemPrice() { return this.itemPrice; }
    /** @return Latest item's description */
    public String getItemDescription() { return this.itemDescription; }
}