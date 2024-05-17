package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.dto.RunningStatusDTO;
import se.kth.iv1350.saleprocess.exceptions.DatabaseConnectionException;
import se.kth.iv1350.saleprocess.exceptions.ExceptionLogger;
import se.kth.iv1350.saleprocess.exceptions.InvalidItemIdentifierException;
import se.kth.iv1350.saleprocess.integrations.AccountingSystemHandler;
import se.kth.iv1350.saleprocess.integrations.DiscountRegistryHandler;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;
import se.kth.iv1350.saleprocess.integrations.PrinterHandler;

public class ControllerTest {
    public ControllerTest() {}

    @Test
    public void test() throws InvalidItemIdentifierException{
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

    @Test
    public void invalidIdentifier() {
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        DiscountRegistryHandler discountRegistryHandler = new DiscountRegistryHandler();
        InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
        PrinterHandler printerHandler = new PrinterHandler();
        Controller controller = new Controller(accountingSystemHandler, discountRegistryHandler, inventorySystemHandler, printerHandler);
        controller.startSale();

        boolean threwException = false;
        try {
            controller.registerItems("thisdoesnotexist", 1);
        }
        catch(InvalidItemIdentifierException e) {
            ExceptionLogger.getInstance().logException(e);
            threwException = true;
        }

        assertEquals(threwException, true);
    }

    @Test
    public void databaseOffline() throws InvalidItemIdentifierException {
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        DiscountRegistryHandler discountRegistryHandler = new DiscountRegistryHandler();
        InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
        PrinterHandler printerHandler = new PrinterHandler();
        Controller controller = new Controller(accountingSystemHandler, discountRegistryHandler, inventorySystemHandler, printerHandler);
        controller.startSale();

        boolean threwException = false;
        try {
            controller.registerItems("database offline", 1);
        }
        catch(DatabaseConnectionException e) {
            ExceptionLogger.getInstance().logException(e);
            threwException = true;
        }

        assertEquals(threwException, true);
    }

    @Test
    public void revenueChangeObservers() throws InvalidItemIdentifierException {
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        DiscountRegistryHandler discountRegistryHandler = new DiscountRegistryHandler();
        InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
        PrinterHandler printerHandler = new PrinterHandler();
        Controller controller = new Controller(accountingSystemHandler, discountRegistryHandler, inventorySystemHandler, printerHandler);
        controller.startSale();

        FakeObserver observer1 = new FakeObserver();
        assertNull(observer1.getLastObservedTotalRevenue());
        controller.registerObserver(observer1);

        FakeObserver observer2 = new FakeObserver();
        assertNull(observer2.getLastObservedTotalRevenue());
        controller.registerObserver(observer2);

        controller.registerItems("abc123", 1);

        controller.endSale();
        controller.registerPayment(12000);

        assertEquals(observer1.getLastObservedTotalRevenue().intValue(), 2990);
        assertEquals(observer2.getLastObservedTotalRevenue().intValue(), 2990);
    }
}
