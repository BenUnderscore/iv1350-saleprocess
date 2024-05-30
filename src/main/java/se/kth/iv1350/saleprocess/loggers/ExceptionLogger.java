package se.kth.iv1350.saleprocess.loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionLogger {
    private PrintWriter logStream;

    private ExceptionLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("exceptionlog.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CANNOT LOG.");
            ioe.printStackTrace();
        }
    }

    private static ExceptionLogger instance = new ExceptionLogger();
    
    /**
     * Singleton instance
     * @return global instance of the ExceptionLogger
     */
    public static ExceptionLogger getInstance() {
        return instance;
    }

    /**
     * Prints exception message and stack trace.
     * @param exception Exception object
     */
    public void logException(Exception exception) {
        logStream.println(exception.getMessage());
        exception.printStackTrace(logStream);
    }
}