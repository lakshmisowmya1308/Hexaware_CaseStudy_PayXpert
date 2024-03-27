package com.hexaware.service;

import com.hexaware.exception.TaxCalculationException;

/**
 * Interface for managing tax-related operations.
 */
public interface ITaxService {

    /**
     * Calculates tax for the specified employee and tax year.
     *
     * @param employeeId the ID of the employee
     * @param taxYear    the tax year for which tax is calculated
     * @throws TaxCalculationException if an error occurs during tax calculation
     */
    void CalculateTax(int employeeId, int taxYear) throws TaxCalculationException;

    /**
     * Retrieves a tax record by its ID.
     *
     * @param taxId the ID of the tax record to retrieve
     */
    void GetTaxById(int taxId);

    /**
     * Retrieves tax records for a specific employee.
     *
     * @param employeeId the ID of the employee
     */
    void GetTaxesForEmployee(int employeeId);

    /**
     * Retrieves tax records for a specific tax year.
     *
     * @param taxYear the tax year for which tax records are retrieved
     */
    void GetTaxesForYear(int taxYear);
}
