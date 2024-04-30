package se.kth.iv1350.saleprocess.dto;

public class ItemInfo {

    public String name;
    public String decription;
    public String id;
    public int price;
    public int vat;
    public int quantity;   

    public ItemInfo(String name, String description, String id, int price, int vat, int quantity){
        this.name = name;
        this.decription = description;
        this.id = id;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
    }

}
