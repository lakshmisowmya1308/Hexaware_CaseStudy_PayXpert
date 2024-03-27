package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.hexaware.dao.PayrollService;
import com.hexaware.model.Payroll;

/**
 * This class contains unit tests for the CalculateNetSalaryAfterDeductions method in the PayrollService class.
 */

public class CalculateNetSalaryAfterDeductions {
	
	private PayrollService ps;
	
	@Before
    public void setUp() {
        ps = new PayrollService();
    }

	/**
	 * This method tests the CalculateNetSalaryAfterDeductions method of the PayrollService class
	 * by checking if the calculated net salary matches the expected net salary after deductions for a given payroll instance.
	 */

    @Test
    public void testCalculateGrossSalaryForEmployee() {
    	
    	Payroll p = new Payroll();
    	
    	p.setPayrollID(2013);
    	
    	float BasicSalary = 15000;
    	float OverTimePay = 1000;
    	float Deductions = 700;
    	float ExpectedNetSalary = BasicSalary+OverTimePay-Deductions;
    	//System.out.println(ExpectedNetSalary);
    	        
        assertEquals(ExpectedNetSalary, ps.CalculateNetSalaryAfterDeductions(p), 0.0); 
    } 
 
}