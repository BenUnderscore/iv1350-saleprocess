package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.exceptions.InvalidItemIdentifierException;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;

public class InventorySystemHandlerTest {
    public InventorySystemHandlerTest() {}

    @Test
    public void test() throws InvalidItemIdentifierException{
        InventorySystemHandler handler = new InventorySystemHandler();

        ItemInfoDTO item1 = handler.getItem("abc123");
        assertEquals(0, item1.getQuantity());

        ItemInfoDTO[] items = new ItemInfoDTO[] { item1 };

        handler.updateInventory(items);
    }

    
}
