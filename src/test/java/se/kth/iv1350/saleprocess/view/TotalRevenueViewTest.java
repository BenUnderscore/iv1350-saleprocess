package se.kth.iv1350.saleprocess.view;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TotalRevenueViewTest {

    public TotalRevenueViewTest() {}

    @Test
    public void testPrint(){
        TotalRevenueView trview = new TotalRevenueView();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        trview.onTotalRevenueChanged(15000);

        assertEquals("New total revenue: 150.00 SEK\n", out.toString());
        out.reset();
    }
}