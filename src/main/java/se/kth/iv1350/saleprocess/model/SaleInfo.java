package se.kth.iv1350.saleprocess.model;

import java.time.LocalDateTime;
import java.util.List;

import se.kth.iv1350.saleprocess.integrations.discounts.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.dto.ReceiptDTO;

public class SaleInfo {
    private List<ItemInfoDTO> itemList;
    private int preDiscountPrice;
    private int postDiscountPrice;

    public SaleInfo(List<ItemInfoDTO> itemList, int totalPrice ){
        this.itemList = itemList;
        this.preDiscountPrice = totalPrice;
        this.postDiscountPrice = totalPrice;
    }

    /**
     * @return list of items
     */
    public List<ItemInfoDTO> getItemList(){
        return itemList;
    }
    /**
     * @return price before the discounts are applied
     */
    public int getPreDiscountPrice() {
        return preDiscountPrice;
    }
    /**
     * @return price after the discounts were applied
     */
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

    private int calculateTotalVat(List<ItemInfoDTO> items) {
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
}
