package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;

public class InventorySystemHandlerTest {
    public InventorySystemHandlerTest() {}

    @Test
    public void test() {
        InventorySystemHandler handler = new InventorySystemHandler();

        ItemInfo item1 = handler.getItem("abc123");
        assertEquals(0, item1.quantity);

        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        items.add(item1);

        handler.updateInventory(items);
    }
}
