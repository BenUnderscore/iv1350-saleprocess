package se.kth.iv1350.saleprocess.exceptions;

/**
 * Database connection error, database cannot be reached. 
 */
public class DatabaseConnectionException extends RuntimeException {
    public DatabaseConnectionException(String message) {
        super(message);
    }

    public DatabaseConnectionException(String message, Exception cause) {
        super(message, cause);
    }
}