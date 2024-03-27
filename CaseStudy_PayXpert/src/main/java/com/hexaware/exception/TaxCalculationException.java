package com.hexaware.exception;

/**
 * Exception thrown when there is an issue with tax calculation.
 */
public class TaxCalculationException extends Exception {

    /**
     * Constructs a new TaxCalculationException with a default message.
     */
    public TaxCalculationException() {
        super("Tax calculation exception");
    }

    /**
     * Returns a string representation of this TaxCalculationException.
     *
     * @return a string representation of this TaxCalculationException.
     */
    @Override
    public String toString() {
        return "Tax calculation exception";
    }
}
