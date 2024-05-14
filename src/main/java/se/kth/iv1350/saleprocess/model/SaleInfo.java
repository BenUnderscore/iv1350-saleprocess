package se.kth.iv1350.saleprocess.model;

import java.time.LocalDateTime;

import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.dto.ReceiptDTO;

public class SaleInfo {
    private ItemInfoDTO[] itemList;
    private int preDiscountPrice;
    private int postDiscountPrice;

    public SaleInfo(ItemInfoDTO[] itemList, int totalPrice ){
        this.itemList = itemList;
        this.preDiscountPrice = totalPrice;
        this.postDiscountPrice = totalPrice;
    }

    public ItemInfoDTO[] getItemList(){
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
    public ReceiptDTO createReceipt(int amountPaid){
        LocalDateTime currentDate = LocalDateTime.now();
        int change = amountPaid - postDiscountPrice;
        int VAT = calculateTotalVat(itemList);
        ReceiptDTO receipt = new ReceiptDTO(currentDate, preDiscountPrice, postDiscountPrice, amountPaid, change, itemList, VAT);
        return receipt;
    }

    private int calculateTotalVat(ItemInfoDTO[] items) {
        int total = 0;
        for(ItemInfoDTO item : items) {
            total += (item.getPrice() * item.getQuantity()) * item.getVat() / 100;
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
