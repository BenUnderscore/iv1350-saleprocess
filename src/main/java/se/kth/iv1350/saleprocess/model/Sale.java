package se.kth.iv1350.saleprocess.model;

import se.kth.iv1350.saleprocess.dto.ItemInfo;
import java.util.ArrayList;

/**
 * Works with itemList. Can add items, calculate total price and create a saleInfo object
 */
public class Sale {
    private ArrayList<ItemInfo> itemList;
    
    public Sale(ArrayList<ItemInfo> itemList){
        this.itemList = itemList;
    }

    /**
     * Adds a new item to the sale list. If an item is already in the list, the method will just increase the quantity of the object. Otherwise, it will add object to the list.
     * @param newItem The item to add/modify
     * @param itemQuantity Quantity of the newItem
     */
    public void addItems(ItemInfo newItem, int itemQuantity){
        for(ItemInfo itemFromList : itemList){
            if(itemFromList.id.equals(newItem.id)){
                itemFromList.quantity += itemQuantity;
                return;
            }
        }
        newItem.quantity = itemQuantity;
        itemList.add(newItem);
    }

    /**
     * Calculates total price including VAT
     * @return total price including VAT
     */
    public int calculateTotal(){
        int total = 0;
        for(ItemInfo itemFromList : itemList){
            total += itemFromList.price * itemFromList.quantity;
        }
        return total;
    }

    /**
     * Creates an object of type SaleInfo
     * @return Object with all information about a sale
     */
    public SaleInfo finilizeSaleInfo(){
        int total = this.calculateTotal();
        
        SaleInfo saleInfo = new SaleInfo(itemList, total);

        return saleInfo;
    }

}
