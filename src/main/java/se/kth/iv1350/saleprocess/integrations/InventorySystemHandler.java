package se.kth.iv1350.saleprocess.integrations;

import java.util.HashMap;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.exceptions.InvalidItemIdentifierException;

public class InventorySystemHandler {
    private HashMap<String, ItemInfoDTO> database;

    private void addItem(String name, String id, int price, String description, int vat) {
        database.put(id, new ItemInfoDTO(name, description, id, price, vat, 0));
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
        database = new HashMap<String, ItemInfoDTO>();
        addExampleData();
    }

    /**
     * Fetches an item from an external inventory system
     * @param id Item's identification
     * @return An ItemInfo object
     * @throws InvalidItemIdentifierException
     */
    public ItemInfoDTO getItem(String id) throws InvalidItemIdentifierException{
        ItemInfoDTO fetchedItem = database.getOrDefault(id, null);
        if(fetchedItem == null){
            throw new InvalidItemIdentifierException(id);
        }
        return fetchedItem;
    }

    /**
     * Makes an update call to an external inventory system
     * @param itemList Full item list in a sale
     */
    public void updateInventory(ItemInfoDTO[] itemList) {
        System.out.println("Inventory updated.");
    }
}
