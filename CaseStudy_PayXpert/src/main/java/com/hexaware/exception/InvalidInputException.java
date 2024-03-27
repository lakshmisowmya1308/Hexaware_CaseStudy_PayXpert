package com.hexaware.exception;

/**
 * Exception thrown when invalid input is detected.
 */
public class InvalidInputException extends Exception {

    /**
     * Constructs a new InvalidInputException with a default message.
     */
    public InvalidInputException() {
        super("Invalid input exception");
    }

    /**
     * Returns a string representation of this InvalidInputException.
     *
     * @return a string representation of this InvalidInputException.
     */
    @Override
    public String toString() {
        return "Invalid input exception";
    }
}
