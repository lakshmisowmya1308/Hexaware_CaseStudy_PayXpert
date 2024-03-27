package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.hexaware.dao.TaxService;
import com.hexaware.exception.TaxCalculationException;

/**
 * This class contains a unit test to verify tax calculation for a high-income employee in the TaxService class.
 */

public class VerifyTaxCalculationForHighIncomeEmployee {

    private TaxService taxService;
    private int highIncomeEmployeeId;

    @Before
    public void setUp() {
        taxService = new TaxService();
        highIncomeEmployeeId = 1007;
    }

    /**
     * This method tests tax calculation for a high-income employee by verifying that the calculated tax amount matches the expected value.
     * It throws a TaxCalculationException if an error occurs during the tax calculation process.
     */

    @Test
    public void testTaxCalculationForHighIncomeEmployee() throws TaxCalculationException {
        float expectedTaxAmount = 2250;
		float calculatedTaxAmount = taxService.TaxCalculation(highIncomeEmployeeId);
		//System.out.println(calculatedTaxAmount);
		assertEquals(expectedTaxAmount, calculatedTaxAmount, 0.0);
    }
}
