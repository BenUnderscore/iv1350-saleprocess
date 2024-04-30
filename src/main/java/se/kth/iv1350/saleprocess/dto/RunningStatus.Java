package se.kth.iv1350.saleprocess.dto;

class RunningStatus{
    int runningTotal;
    int itemPrice;
    String itemDescription;

    /**
     * Makes a RunningStatus DTO that is sent to the view
     * @param runningTotal the current total of the sale
     * @param itemPrice price of the item that was just registered
     * @param itemDescription description of the item
     */
    public RunningStatus(int runningTotal, int itemPrice, String itemDescription){
        this.runningTotal = runningTotal;
        this.itemPrice = itemPrice;
        this. itemDescription = itemDescription;
    }
}