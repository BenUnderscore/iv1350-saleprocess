package se.kth.iv1350.saleprocess.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.integrations.AccountingSystemHandler;
import se.kth.iv1350.saleprocess.integrations.InventorySystemHandler;
import se.kth.iv1350.saleprocess.integrations.PrinterHandler;
import se.kth.iv1350.saleprocess.integrations.discounts.DiscountRegistryHandler;


public class ViewTest {
    public ViewTest() {}

    @Test
    public void testPrint() {
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        DiscountRegistryHandler discountRegistryHandler = new DiscountRegistryHandler();
        InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
        PrinterHandler printerHandler = new PrinterHandler();
        Controller controller = new Controller(accountingSystemHandler, discountRegistryHandler, inventorySystemHandler, printerHandler);
        View view = new View(controller);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.startSale();
        assertEquals("A new sale has started.", out.toString().split("\n")[0]);
        out.reset();

        view.scanOneItem("abc123");
        assertEquals("Running total: 29.90", out.toString().split("\n")[0]);
        assertEquals("You added new item to sale!", out.toString().split("\n")[1]);
        assertEquals("BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free", out.toString().split("\n")[2]);
        assertEquals("It costs: 29.90", out.toString().split("\n")[3]);
        out.reset();

        view.endSale();
        assertEquals("Sale has ended with total price of 29.90 kr.", out.toString().split("\n")[0]);
        out.reset();

        view.requestDiscount("dante");
        assertEquals("Discounts were applied, new price: 26.91 kr.", out.toString().split("\n")[0]);
        out.reset();

        view.registerPayment(10000);
        assertEquals("Customer paid 100.00 kr, change is 73.09 kr.", out.toString().split("\n")[13]);
        out.reset();
    }
}