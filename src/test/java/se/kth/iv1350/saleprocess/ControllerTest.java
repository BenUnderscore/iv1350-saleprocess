package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.dto.RunningStatusDTO;
import se.kth.iv1350.saleprocess.integrations.AccountingSystemHandler;
import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;
import se.kth.iv1350.saleprocess.integrations.PrinterHandler;

public class ControllerTest {
    public ControllerTest() {}

    @Test
    public void test() {
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        DiscountRegistryHandler discountRegistryHandler = new DiscountRegistryHandler();
        InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
        PrinterHandler printerHandler = new PrinterHandler();
        Controller controller = new Controller(accountingSystemHandler, discountRegistryHandler, inventorySystemHandler, printerHandler);
        controller.startSale();
        RunningStatusDTO status1 = controller.registerItems("abc123", 1);
        assertEquals("BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free", status1.getItemDescription());
        assertEquals(2990, status1.getItemPrice());
        assertEquals(2990, status1.getRunningTotal());

        RunningStatusDTO status2 = controller.registerItems("abc123", 1);
        assertEquals("BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free", status2.getItemDescription());
        assertEquals(2990, status2.getItemPrice());
        assertEquals(5980, status2.getRunningTotal());

        RunningStatusDTO status3 = controller.registerItems("ghi789", 1);
        assertEquals("Pilot Rondo, mechanical pencil, 0.7mm", status3.getItemDescription());
        assertEquals(4900, status3.getItemPrice());
        assertEquals(10880, status3.getRunningTotal());

        assertEquals(10880, controller.endSale());
        assertEquals(1120, controller.registerPayment(12000));
    }
}
