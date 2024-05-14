package se.kth.iv1350.saleprocess.dto;

public class ItemInfoDTO {

    private String name;
    private String description;
    private String id;
    private int price;
    private int vat;
    private int quantity; 


    public ItemInfoDTO(String name, String description, String id, int price, int vat, int quantity){
        this.name = name;
        this.description = description;
        this.id = id;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
    }


    /** @return Item's name */
    public String getName() { return name; }
    /** @return Item's description */
    public String getDescription() { return description; }
    /** @return Item's identification. Can be any string */
    public String getId() { return id; }
    /** @return Price including VAT */
    public int getPrice() { return price; }
    /** @return Plain VAT price (in kr) */
    public int getVat() { return vat; }
    /** @return Amount of the specific items. 0 for non-sale item */
    public int getQuantity() { return quantity; }
}
