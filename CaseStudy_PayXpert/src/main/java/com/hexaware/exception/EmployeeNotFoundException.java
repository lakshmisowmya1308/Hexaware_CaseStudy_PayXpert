package com.hexaware.exception;

/**
 * Exception thrown when an employee is not found.
 */
public class EmployeeNotFoundException extends Exception {

    /**
     * Constructs a new EmployeeNotFoundException with a default message.
     */
    public EmployeeNotFoundException() {
        super("Employee not found");
    }

    /**
     * Returns a string representation of this EmployeeNotFoundException.
     * 
     * @return a string representation of this EmployeeNotFoundException.
     */
    @Override
    public String toString() {
        return "Employee not found";
    }
}
