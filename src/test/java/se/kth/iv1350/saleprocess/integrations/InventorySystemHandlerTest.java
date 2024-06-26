package se.kth.iv1350.saleprocess.integrations;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.exceptions.DatabaseConnectionException;
import se.kth.iv1350.saleprocess.exceptions.InvalidItemIdentifierException;

public class InventorySystemHandlerTest {
    public InventorySystemHandlerTest() {}

    @Test
    public void getItemTest() throws InvalidItemIdentifierException{
        InventorySystemHandler handler = new InventorySystemHandler();

        ItemInfoDTO item1 = handler.getItem("abc123");
        assertEquals(0, item1.getQuantity());

        ArrayList<ItemInfoDTO> items = new ArrayList<ItemInfoDTO>();
        items.add(item1);

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
