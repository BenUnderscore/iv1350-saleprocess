package se.kth.iv1350.saleprocess.model;
import java.util.ArrayList;
import java.time.LocalDateTime;
import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.dto.ItemInfo;

public class SaleInfo {
    public ArrayList<ItemInfo> itemList;
    public int totalPrice;
    public int currentTotal;
    public int discountAmount; 
    public LocalDateTime currentDate; 

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

    public void createReceipt(){
        this.currentDate = LocalDateTime.now();
    }

    public void applyDiscount(DiscountRegistryHandler DiscountRegistryHandler, String customerID){
        this.discountAmount = DiscountRegistryHandler.getDiscount(customerID, totalPrice, itemList);
        currentTotal -= discountAmount;
    } 

    public Receipt createReceipt(){
        
    }
}
