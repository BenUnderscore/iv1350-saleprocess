package se.kth.iv1350.saleprocess.integrations;

import java.time.format.DateTimeFormatter;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.dto.ReceiptDTO;
import se.kth.iv1350.saleprocess.util.PriceUtilities;

public class PrinterHandler {
    public PrinterHandler() {
    }

    private void appendItems(ItemInfoDTO[] items, StringBuilder stringBuilder) {
        for(ItemInfoDTO item : items) {
            int itemTotalPrice = item.getPrice() * item.getQuantity();
            stringBuilder.append(
                String.format(
                    "%-23s %3d x %s SEK %s SEK %n",
                    item.getName(),
                    item.getQuantity(),
                    PriceUtilities.formatPrice(item.getPrice()),
                    PriceUtilities.formatPrice(itemTotalPrice)
                )
            );
        }
    }

    /**
     * Sends call to an external printer to print a sale receipt
     * @param receipt Sale's receipt with all relevant information
     */
    public void printReceipt(ReceiptDTO receipt) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("------------------ Begin receipt -------------------\n");
        stringBuilder.append("Time of Sale: ");
        stringBuilder.append(receipt.getDateAndTime().format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm")));
        stringBuilder.append("\n");

        appendItems(receipt.getItemList(), stringBuilder);
        stringBuilder.append(
            "Total: " + PriceUtilities.formatPrice(receipt.getPostDiscountPrice()) + " SEK\n"
        );

        stringBuilder.append("\n");

        stringBuilder.append(
            "VAT: " + PriceUtilities.formatPrice(receipt.getVAT()) + " SEK\n"
        );

        stringBuilder.append("\n");

        stringBuilder.append(
            "Cash: " + PriceUtilities.formatPrice(receipt.getAmountPaid()) + " SEK\n"
        );

        stringBuilder.append(
            "Change: " + PriceUtilities.formatPrice(receipt.getChange()) + " SEK\n"
        );

        stringBuilder.append("------------------ End receipt ---------------------\n");

        System.out.print(stringBuilder.toString());
        System.out.flush();
    }
}
