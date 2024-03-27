package com.hexaware.test;

import org.junit.Test;
import com.hexaware.dao.EmployeeService;
import com.hexaware.exception.EmployeeNotFoundException;

/**
 * This class contains a unit test to verify error handling for the case when an invalid employee ID is provided to the GetEmployeeById method.
 */

public class VerifyErrorHandlingForInvalidEmployeeData {

    @Test(expected = EmployeeNotFoundException.class)
    /**
     * This method tests error handling in the EmployeeService class by verifying that an EmployeeNotFoundException is thrown
     * when attempting to retrieve an employee with an invalid employee ID using the GetEmployeeById method.
     */

    public void testEmployeeNotFound() throws EmployeeNotFoundException {
    	
        EmployeeService employeeService = new EmployeeService();

        int invalidEmployeeId = 100;
        employeeService.GetEmployeeById(invalidEmployeeId);
    }
}

