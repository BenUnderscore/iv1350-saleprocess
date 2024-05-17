package se.kth.iv1350.saleprocess.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionLogger {
    private PrintWriter logStream;

    private ExceptionLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CANNOT LOG.");
            ioe.printStackTrace();
        }
    }

    private static ExceptionLogger instance = new ExceptionLogger();
    
    public static ExceptionLogger getInstance() {
        return instance;
    }

    public void logException(Exception exception) {
        logStream.println(exception.getMessage());
        exception.printStackTrace(logStream);
    }
}