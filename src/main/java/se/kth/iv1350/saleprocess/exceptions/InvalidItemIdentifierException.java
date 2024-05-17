package se.kth.iv1350.saleprocess.exceptions;

/**
 * Item Identifier is not found in the Inventory System
*/
public class InvalidItemIdentifierException extends Exception
{
    private static String createMessage(String id) {
        return "Item Identifier \"" + id + "\" is not found in the Inventory System!";
    }

    public InvalidItemIdentifierException(String invalidId) {
        super(createMessage(invalidId));
    }

    public InvalidItemIdentifierException(String invalidId, Exception cause) {
        super(createMessage(invalidId), cause);
    }
}