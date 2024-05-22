package se.kth.iv1350.saleprocess.integrations;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.dto.ReceiptDTO;


public class PrinterHandlerTest {
    public PrinterHandlerTest() {
    }

    @Test
    public void test1() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        ArrayList<ItemInfoDTO> items = new ArrayList<ItemInfoDTO>();
        items.add(
            new ItemInfoDTO(
                "BigWheel Oatmeal",
                "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free",
                "abc123",
                2990,
                6,
                4
            )
        );
        items.add(
            new ItemInfoDTO(
                "Nyckelmix 120g",
                "drink mix, unlocks senses",
                "jkl012",
                6900,
                12,
                420
            )
        );

        ReceiptDTO receipt = new ReceiptDTO(
            LocalDateTime.of(2024, Month.APRIL, 30, 15, 29, 44),
            2699960,
            2699960,
            3000000,
            300040,
            items,
            348477
        );

        PrinterHandler printerHandler = new PrinterHandler();
        printerHandler.printReceipt(receipt);

        String result = out.toString();
        String[] correctResultLines = new String[] {
            "------------------ Begin receipt -------------------",
            "Time of Sale: 2024-04-30 15:29",
            "BigWheel Oatmeal          4 x 29.90 SEK 119.60 SEK ",
            "Nyckelmix 120g          420 x 69.00 SEK 28980.00 SEK ",
            "Total: 26999.60 SEK",
            "",
            "VAT: 3484.77 SEK",
            "",
            "Cash: 30000.00 SEK",
            "Change: 3000.40 SEK",
            "------------------ End receipt ---------------------"
        };

        String correctResult = String.join("\n", correctResultLines) + "\n";
        assertEquals("No message.", correctResult, result);
    }
}
