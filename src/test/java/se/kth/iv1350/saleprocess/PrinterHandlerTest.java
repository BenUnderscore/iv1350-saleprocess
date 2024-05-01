package se.kth.iv1350.saleprocess;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.dto.Receipt;
import se.kth.iv1350.saleprocess.integrations.PrinterHandler;

public class PrinterHandlerTest {
    public PrinterHandlerTest() {
    }

    @Test
    public void test1() {
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        items.add(new ItemInfo(
            "BigWheel Oatmeal",
            "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free",
            "abc123",
            2990,
            6,
            4
        ));

        items.add(new ItemInfo(
            "Nyckelmix 120g",
            "drink mix, unlocks senses",
            "jkl012",
            6400,
            12,
            420
        ));

        Receipt receipt = new Receipt(
            LocalDateTime.of(2024, Month.APRIL, 30, 15, 29, 44),
            2699960,
            2699960,
            3000000,
            300040,
            items
        );

        PrinterHandler printerHandler = new PrinterHandler();
        printerHandler.printReceipt(receipt);
    }
}
