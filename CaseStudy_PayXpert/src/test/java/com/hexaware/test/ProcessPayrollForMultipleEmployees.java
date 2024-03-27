package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.PayrollService;
import com.hexaware.model.Payroll;

/**
 * Test class to verify the end-to-end payroll processing for a batch of employees.
 */
public class ProcessPayrollForMultipleEmployees {
    
    private PayrollService payrollService;
    private List<Payroll> payrollList;

    /**
     * Sets up the test environment by initializing the payroll service and populating the payroll list.
     */
    @Before
    public void setUp() {
    	 payrollService = new PayrollService();
    	    payrollList = new ArrayList<>();

    	    // payroll details
    	    Payroll payroll1 = new Payroll();
    	    payroll1.setPayrollID(2001);
    	    payroll1.setEid(1001);
    	    payroll1.setPayPeriodStartDate(java.sql.Date.valueOf("2024-03-01"));
    	    payroll1.setPayPeriodEndDate(java.sql.Date.valueOf("2024-03-15"));
    	    payroll1.setBasicSalary(2000.0f);
    	    payroll1.setOvertimePay(100.0f);
    	    payroll1.setDeductions(50.0f);
    	    payroll1.setNetSalary(2050.0f);
    	    payrollList.add(payroll1);

    	    //another details
    	    Payroll payroll2 = new Payroll();
    	    payroll2.setPayrollID(2006);
    	    payroll2.setEid(1001);
    	    payroll2.setPayPeriodStartDate(java.sql.Date.valueOf("2024-03-16"));
    	    payroll2.setPayPeriodEndDate(java.sql.Date.valueOf("2024-03-31"));
    	    payroll2.setBasicSalary(2000.0f);
    	    payroll2.setOvertimePay(120.0f);
    	    payroll2.setDeductions(60.0f);
    	    payroll2.setNetSalary(2060.0f);
    	    payrollList.add(payroll2);
    	    
    	  
    }

    /**
     * Test method to verify the end-to-end payroll processing for a batch of employees.
     */
    @Test
    public void testProcessPayrollForMultipleEmployees() {
        assertNotNull(payrollList);
        
        for (Payroll payroll : payrollList) {
            int payrollId = payroll.getPayrollID();
            Payroll rp = payrollService.GetPayrollById(payrollId);
            assertNotNull(rp);
            assertEquals("payroll ID Unmatch", payrollId, rp.getPayrollID());
            assertEquals("employee ID Unmatch", payroll.getEid(), rp.getEid());
            assertEquals("start date Unmatch", payroll.getPayPeriodStartDate(), rp.getPayPeriodStartDate());
            assertEquals("end date Unmatch", payroll.getPayPeriodEndDate(), rp.getPayPeriodEndDate());
            assertEquals("basic salary Unmatch", payroll.getBasicSalary(), rp.getBasicSalary(), 0.0);
            assertEquals("overtime pay Unmatch", payroll.getOvertimePay(), rp.getOvertimePay(), 0.0);
            assertEquals("deductions Unmatch", payroll.getDeductions(), rp.getDeductions(), 0.0);
            assertEquals("net salary Unmatch", payroll.getNetSalary(), rp.getNetSalary(), 0.0);
        }
    }
}
