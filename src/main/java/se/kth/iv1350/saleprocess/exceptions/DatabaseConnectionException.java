package se.kth.iv1350.saleprocess.exceptions;

public class DatabaseConnectionException extends RuntimeException {
    public DatabaseConnectionException(String message) {
        super(message);
    }

    public DatabaseConnectionException(String message, Exception cause) {
        super(message, cause);
    }
}