package se.kth.iv1350.saleprocess.integrations;

import se.kth.iv1350.saleprocess.dto.ReceiptDTO;

public class AccountingSystemHandler {
    public AccountingSystemHandler(){

    }

    /**
     * Logs sale into the external accounting system. Currentely represented by a sysout message and does nothing else, as we do not know how the external system works.
     */
    public void logSale(ReceiptDTO receipt){
        
        /* Log sale code here */

        /* Break down "receipt" into relevant parts */

        /* Call external accounting system and send relevant parts of receipt or the whole receipt */
        System.out.println("Sale was logged to the external accounting system.");
        
    }
}
