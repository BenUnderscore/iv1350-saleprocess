package se.kth.iv1350.saleprocess.integrations.discounts;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;

class CustomerDiscount implements Discount{

    private final int PERCENTAGE = 10;
    private String customerID;

    public CustomerDiscount(String customerID) {
        this.customerID = customerID;
    }
    
    @Override
    public int getDiscount(String customerID, int total, ItemInfoDTO[] itemList){
        if(this.customerID.equals(customerID)) { return (total * PERCENTAGE) / 100; }
        return 0;
    }
}
