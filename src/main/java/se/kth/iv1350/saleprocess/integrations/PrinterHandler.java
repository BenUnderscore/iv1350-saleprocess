package se.kth.iv1350.saleprocess.integrations;

import java.time.format.DateTimeFormatter;
import java.util.List;

import se.kth.iv1350.saleprocess.dto.ItemInfo;
import se.kth.iv1350.saleprocess.dto.Receipt;

public class PrinterHandler {
    public PrinterHandler() {
    }

    private void appendItems(List<ItemInfo> items, StringBuilder stringBuilder) {
        for(ItemInfo item : items) {
            int itemTotalPrice = item.price * item.quantity;
            stringBuilder.append(
                String.format(
                    "%-23s %3d x %2d.%02d SEK %5d.%02d SEK %n",
                    item.name,
                    item.quantity,
                    item.price / 100,
                    item.price % 100,
                    itemTotalPrice / 100,
                    itemTotalPrice % 100
                )
            );
        }
    }

    /**
     * Sends call to an external printer to print a sale receipt
     * @param receipt Sale's receipt with all relevant information
     */
    public void printReceipt(Receipt receipt) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("------------------ Begin receipt -------------------\n");
        stringBuilder.append("Time of Sale: ");
        stringBuilder.append(receipt.dateAndTime.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm")));
        stringBuilder.append("\n");

        appendItems(receipt.itemList, stringBuilder);
        stringBuilder.append(
            String.format(
                "Total: %38d.%02d SEK%n",
                receipt.postDiscountPrice / 100,
                receipt.postDiscountPrice % 100
            )
        );

        stringBuilder.append("\n");

        stringBuilder.append(
            String.format(
                "VAT: %01d.%02d SEK%n",
                receipt.VAT / 100,
                receipt.VAT % 100
            )
        );

        stringBuilder.append("\n");

        stringBuilder.append(
            String.format(
                "Cash: %01d.%02d SEK%n",
                receipt.amountPaid / 100,
                receipt.amountPaid % 100
            )
        );

        stringBuilder.append(
            String.format(
                "Change: %01d.%02d SEK%n",
                receipt.change / 100,
                receipt.change % 100
            )
        );

        stringBuilder.append("------------------ End receipt ---------------------\n");

        System.out.print(stringBuilder.toString());
        System.out.flush();
    }
}
