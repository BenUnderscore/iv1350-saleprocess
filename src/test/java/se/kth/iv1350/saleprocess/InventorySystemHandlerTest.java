package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;

public class InventorySystemHandlerTest {
    public InventorySystemHandlerTest() {}

    @Test
    public void test() {
        InventorySystemHandler handler = new InventorySystemHandler();

        ItemInfoDTO item1 = handler.getItem("abc123");
        assertEquals(0, item1.getQuantity());

        ArrayList<ItemInfoDTO> items = new ArrayList<ItemInfoDTO>();
        items.add(item1);

        handler.updateInventory(items);
    }
}
