package se.kth.iv1350.saleprocess.integrations;

import java.util.HashMap;
import java.util.HashSet;

import se.kth.iv1350.saleprocess.dto.ItemInfo;

public class InventorySystemHandler {
    private HashMap<String, ItemInfo> database;

    private void addItem(String name, String id, int price, String description, int vat) {
        database.put(id, new ItemInfo(name, id, price, description, vat));
    }

    private void addExampleData() {
        addItem(
            "BigWheel Oatmeal",
            "abc123",
            2990,
            "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free",
            6
        );

        addItem(
            "YouGoGo Blueberry",
            "def456",
            1490,
            "YouGoGo Blueberry 240g, low sugar youghurt, blueberry flavour",
            6
        );

        addItem(
            "Pilot Rondo Green",
            "ghi789",
            4900,
            "Pilot Rondo, mechanical pencil, 0.7mm",
            25
        );

        addItem(
            "Nyckelmix 120g",
            "jkl012",
            6400,
            "drink mix, unlocks senses",
            12
        );
    }
    
    public InventorySystemHandler() {
        database = new HashMap<String, ItemInfo>();
        addExampleData();
    }

    public ItemInfo getItem(String id) {
        return database.getOrDefault(id, null);
    }

    public void updateInventory(ItemInfo[] itemList) {
    }
}
