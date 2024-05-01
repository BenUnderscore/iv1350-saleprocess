package se.kth.iv1350.saleprocess.dto;

public class ItemInfo {

    /** Item's name */
    public String name;
    /** Item's description */
    public String description;
    /** Item's identification. Can be any string */
    public String id;
    /** Price including VAT */
    public int price;
    /** Plain VAT price (in kr) */
    public int vat;
    /** Amount of the specific items. 0 for non-sale item */
    public int quantity;   

    public ItemInfo(String name, String description, String id, int price, int vat, int quantity){
        this.name = name;
        this.description = description;
        this.id = id;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
    }

}
