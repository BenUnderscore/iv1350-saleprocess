package se.kth.iv1350.saleprocess.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.dto.Receipt;

public class SaleInfo {
    private ArrayList<ItemInfo> itemList;
    private int preDiscountPrice;
    private int postDiscountPrice;

    public SaleInfo(ArrayList<ItemInfo> itemList, int totalPrice ){
        this.itemList = itemList;
        this.preDiscountPrice = totalPrice;
        this.postDiscountPrice = totalPrice;
    }

    public ArrayList<ItemInfo> getItemList(){
        return itemList;
    }

    public int getPreDiscountPrice() {
        return preDiscountPrice;
    }

    public int getPostDiscountPrice() {
        return postDiscountPrice;
    }

    /**
     * Puts all of the sale information, including payment date and time on a receipt
     * @param amountPaid How much customer paid
     * @return Receipt object with sale information
     */
    public Receipt createReceipt(int amountPaid){
        LocalDateTime currentDate = LocalDateTime.now();
        int change = amountPaid - postDiscountPrice;
        int VAT = calculateTotalVat(itemList);
        Receipt receipt = new Receipt(currentDate, preDiscountPrice, postDiscountPrice, amountPaid, change, itemList, VAT);
        return receipt;
    }

    private int calculateTotalVat(List<ItemInfo> items) {
        int total = 0;
        for(ItemInfo item : items) {
            total += (item.price * item.quantity) * item.vat / 100;
        }

        return total;
    }

    /**
     * Applies all eligible discounts to the sale, updating the post-discount price
     * @param DiscountRegistryHandler Discount registry handler
     * @param customerID Customer's identification
     */
    public void applyDiscounts(DiscountRegistryHandler discountRegistryHandler, String customerID) {
        int discount = discountRegistryHandler.getDiscount(customerID, preDiscountPrice, itemList);
        postDiscountPrice = preDiscountPrice - discount;
    } 

    public void applyDiscountDummy(int discount){
        postDiscountPrice = preDiscountPrice - discount;
    }
}
