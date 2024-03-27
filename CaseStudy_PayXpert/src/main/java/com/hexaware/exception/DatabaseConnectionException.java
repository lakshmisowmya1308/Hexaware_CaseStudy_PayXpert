/**
 * This package contains exception classes that handle various exceptional scenarios in the application.
 */


package com.hexaware.exception;

/**
 * Exception thrown when there's an error with the database connection.
 */
public class DatabaseConnectionException extends Exception {

    /**
     * Constructs a new DatabaseConnectionException with a default message.
     */
    public DatabaseConnectionException() {
        super("Database connection error");
    }

    /**
     * Returns a string representation of this DatabaseConnectionException.
     * 
     * @return a string representation of this DatabaseConnectionException.
     */
    @Override
    public String toString() {
        return "Database connection error";
    }
}
