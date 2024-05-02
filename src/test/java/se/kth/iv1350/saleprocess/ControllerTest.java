package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.dto.RunningStatus;
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
        RunningStatus status1 = controller.registerItems("abc123", 1);
        assertEquals("BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free", status1.itemDescription);
        assertEquals(2990, status1.itemPrice);
        assertEquals(2990, status1.runningTotal);

        RunningStatus status2 = controller.registerItems("abc123", 1);
        assertEquals("BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free", status2.itemDescription);
        assertEquals(2990, status2.itemPrice);
        assertEquals(5980, status2.runningTotal);

        RunningStatus status3 = controller.registerItems("ghi789", 1);
        assertEquals("Pilot Rondo, mechanical pencil, 0.7mm", status3.itemDescription);
        assertEquals(4900, status3.itemPrice);
        assertEquals(10880, status3.runningTotal);

        assertEquals(10880, controller.endSale());
        assertEquals(1120, controller.registerPayment(12000));
    }
}
