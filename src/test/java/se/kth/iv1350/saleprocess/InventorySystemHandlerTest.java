package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.exceptions.DatabaseConnectionException;
import se.kth.iv1350.saleprocess.exceptions.InvalidItemIdentifierException;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;

public class InventorySystemHandlerTest {
    public InventorySystemHandlerTest() {}

    @Test
    public void getItemTest() throws InvalidItemIdentifierException{
        InventorySystemHandler handler = new InventorySystemHandler();

        ItemInfoDTO item1 = handler.getItem("abc123");
        assertEquals(0, item1.getQuantity());

        ItemInfoDTO[] items = new ItemInfoDTO[] { item1 };

        handler.updateInventory(items);
    }

    @Test
    public void databaseConnectionTest() throws InvalidItemIdentifierException {
        InventorySystemHandler handler = new InventorySystemHandler();

        boolean threwException = false;
        try {
            handler.getItem("database offline");
        }
        catch(DatabaseConnectionException e) {
            e.printStackTrace();
            threwException = true;
        }

        assertEquals(threwException, true);
    }
}
