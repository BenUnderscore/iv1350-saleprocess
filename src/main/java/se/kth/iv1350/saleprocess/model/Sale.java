package se.kth.iv1350.saleprocess.model;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import java.util.ArrayList;

/**
 * Works with itemList. Can add items, calculate total price and create a saleInfo object
 */
public class Sale {
    private ArrayList<ItemInfoDTO> itemList;
    
    public Sale(){
        this.itemList = new ArrayList<ItemInfoDTO>();
    }


    /**
     * Adds a new item to the sale list. If an item is already in the list, the method will just increase the quantity of the object. Otherwise, it will add object to the list.
     * @param newItem The item to add/modify
     * @param itemQuantity Quantity of the newItem
     */
    public void addItems(ItemInfoDTO newItem, int itemQuantity){

        for(int i = 0; i < itemList.size(); i++) {
            ItemInfoDTO itemFromList = itemList.get(i);
            if(itemFromList.getId().equals(newItem.getId())){
                ItemInfoDTO updatedItem = itemInfoWithQuantity(itemFromList, itemFromList.getQuantity() + itemQuantity);
                itemList.set(i, updatedItem);
                return;
            }
        }

        itemList.add(itemInfoWithQuantity(newItem, itemQuantity));
    }

    /**
     * @return New ItemInfoDTO Object with updated quantity
     */
    private static ItemInfoDTO itemInfoWithQuantity(ItemInfoDTO item, int newQuantity){
        return new ItemInfoDTO(
            item.getName(), item.getDescription(), item.getId(), item.getPrice(), item.getVat(), newQuantity
        );
    }

    /**
     * Calculates total price including VAT
     * @return total price including VAT
     */
    public int calculateTotal(){
        int total = 0;
        for(ItemInfoDTO itemFromList : itemList){
            total += itemFromList.getPrice()* itemFromList.getQuantity();
        }
        return total;
    }

    /**
     * Creates an object of type SaleInfo
     * @return Object with all information about a sale
     */
    public SaleInfo finalizeSaleInfo(){
        int total = this.calculateTotal();
        
        ItemInfoDTO[] itemArray = new ItemInfoDTO[itemList.size()];
        itemArray = itemList.toArray(itemArray);
        SaleInfo saleInfo = new SaleInfo(itemArray, total);

        return saleInfo;
    }

}
