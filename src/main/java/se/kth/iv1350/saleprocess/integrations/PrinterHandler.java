package se.kth.iv1350.saleprocess.integrations;

import java.time.format.DateTimeFormatter;
import java.util.List;

import se.kth.iv1350.saleprocess.dto.ItemInfoDTO;
import se.kth.iv1350.saleprocess.dto.ReceiptDTO;

public class PrinterHandler {
    public PrinterHandler() {
    }

    private void appendItems(List<ItemInfoDTO> items, StringBuilder stringBuilder) {
        for(ItemInfoDTO item : items) {
            int itemTotalPrice = item.getPrice() * item.getQuantity();
            stringBuilder.append(
                String.format(
                    "%-23s %3d x %2d.%02d SEK %5d.%02d SEK %n",
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice() / 100,
                    item.getPrice() % 100,
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
    public void printReceipt(ReceiptDTO receipt) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("------------------ Begin receipt -------------------\n");
        stringBuilder.append("Time of Sale: ");
        stringBuilder.append(receipt.getDateAndTime().format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm")));
        stringBuilder.append("\n");

        appendItems(receipt.getItemList(), stringBuilder);
        stringBuilder.append(
            String.format(
                "Total: %38d.%02d SEK%n",
                receipt.getPostDiscountPrice() / 100,
                receipt.getPostDiscountPrice() % 100
            )
        );

        stringBuilder.append("\n");

        stringBuilder.append(
            String.format(
                "VAT: %01d.%02d SEK%n",
                receipt.getVAT() / 100,
                receipt.getVAT() % 100
            )
        );

        stringBuilder.append("\n");

        stringBuilder.append(
            String.format(
                "Cash: %01d.%02d SEK%n",
                receipt.getAmountPaid() / 100,
                receipt.getAmountPaid() % 100
            )
        );

        stringBuilder.append(
            String.format(
                "Change: %01d.%02d SEK%n",
                receipt.getChange() / 100,
                receipt.getChange() % 100
            )
        );

        stringBuilder.append("------------------ End receipt ---------------------\n");

        System.out.print(stringBuilder.toString());
        System.out.flush();
    }
}
