package se.kth.iv1350.saleprocess.exceptions;

/**
 * Item Identifier is not found in the Inventory System
*/
public class InvalidItemIdentifierException extends Exception
{
    private String itemId;

    private static String createMessage(String id) {
        return "Item Identifier \"" + id + "\" is not found in the Inventory System!";
    }

    public InvalidItemIdentifierException(String invalidId) {
        super(createMessage(invalidId));
        itemId = invalidId;
    }

    public InvalidItemIdentifierException(String invalidId, Exception cause) {
        super(createMessage(invalidId), cause);
        itemId = invalidId;
    }

    /**
     * Returns the identificator-cause of the exception
     * @return item identificator
     */
    public String getInvalidId() {
        return itemId;
    }
}