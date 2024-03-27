package com.hexaware.exception;

/**
 * Exception thrown when there is an issue with financial records.
 */
public class FinancialRecordException extends Exception {

    /**
     * Constructs a new FinancialRecordException with a default message.
     */
    public FinancialRecordException() {
        super("Financial record exception");
    }

    /**
     * Returns a string representation of this FinancialRecordException.
     *
     * @return a string representation of this FinancialRecordException.
     */
    @Override
    public String toString() {
        return "Financial record exception";
    }
}
