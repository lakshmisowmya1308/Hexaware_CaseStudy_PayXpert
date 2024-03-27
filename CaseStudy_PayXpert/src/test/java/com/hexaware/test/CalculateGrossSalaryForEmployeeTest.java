package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.hexaware.dao.PayrollService;

/**
 * This class contains unit tests for the CalculateGrossSalary method in the PayrollService class.
 */

public class CalculateGrossSalaryForEmployeeTest {
    
    private PayrollService ps;

    @Before
    public void setUp() {
        ps = new PayrollService();
    }

    /**
     * This method tests the CalculateGrossSalary method of the PayrollService class
     * by checking if the calculated gross salary matches the expected gross salary for a given employee ID.
     */

    @Test
    public void testCalculateGrossSalaryForEmployee() {
    	
    	int eid = 1001;
        float expectedgs = 4220; 

        assertEquals(expectedgs, ps.CalculateGrossSalary(eid), 0.0); 
    }
}
