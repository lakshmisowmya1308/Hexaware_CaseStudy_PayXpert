package com.hexaware.exception;

/**
 * Exception thrown when there is an issue with payroll generation.
 */
public class PayrollGenerationException extends Exception {

    /**
     * Constructs a new PayrollGenerationException with a default message.
     */
    public PayrollGenerationException() {
        super("Payroll generation exception");
    }

    /**
     * Returns a string representation of this PayrollGenerationException.
     *
     * @return a string representation of this PayrollGenerationException.
     */
    @Override
    public String toString() {
        return "Payroll generation exception";
    }
}
