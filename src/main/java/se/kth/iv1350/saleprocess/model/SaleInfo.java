package se.kth.iv1350.saleprocess.model;
import java.util.ArrayList;

public class SaleInfo {
    ArrayList<ItemInfo> itemList;
    int totalPrice;
    int currentTotal;

    public SaleInfo(ArrayList<ItemInfo> itemList, int totalPrice ){
        this.itemList = itemList;
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {

        return totalPrice;
    }

    public int getCurrentTotal() {

        return currentTotal;
    }

    public void createReceipt(){
        
    }

    public ArrayList<ItemInfo> getItemList(){

    }

    public void applyDiscount(){

    }

    

}
