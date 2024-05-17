package se.kth.iv1350.saleprocess.util;

public class PriceUtilities {

    /**
     * Converts an amount in 100ths of a currency to the whole of a currency.
     * For example 1023 gets converted to "10.23"
     */
    public static String formatPrice(int amount) {
        return String.format("%01d.%02d", amount / 100, amount % 100);
    }

}