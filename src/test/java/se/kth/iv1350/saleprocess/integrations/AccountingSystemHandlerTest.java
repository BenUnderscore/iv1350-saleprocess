package se.kth.iv1350.saleprocess.integrations;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class AccountingSystemHandlerTest {
    public AccountingSystemHandlerTest() {}

    @Test
    public void testPrint()
    {
        AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    
        accountingSystemHandler.logSale(null);
        assertEquals("Sale was logged to the external accounting system.\n", out.toString());
    }
}
