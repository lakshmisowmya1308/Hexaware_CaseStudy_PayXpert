package com.hexaware.service;

import java.util.Date;

import com.hexaware.exception.PayrollGenerationException;
import com.hexaware.model.Payroll;

/**
 * Interface for managing payroll-related operations.
 */
public interface IPayrollService {

    /**
     * Generates payroll records for the specified employee within the given date range.
     *
     * @param p          the payroll object containing payroll details
     * @param employeeId the ID of the employee
     * @param startDate  the start date of the payroll period
     * @param endDate    the end date of the payroll period
     * @throws PayrollGenerationException if an error occurs while generating the payroll
     */
    void GeneratePayroll(Payroll p, int employeeId, Date startDate, Date endDate) throws PayrollGenerationException;

    /**
     * Retrieves a payroll record by its ID.
     *
     * @param payrollId the ID of the payroll record to retrieve
     * @return 
     */
    Payroll GetPayrollById(int payrollId);

    /**
     * Retrieves payroll records for a specific employee.
     *
     * @param employeeId the ID of the employee
     */
    void GetPayrollsForEmployee(int employeeId);

    /**
     * Retrieves payroll records within the specified period.
     *
     * @param startDate the start date of the period
     * @param endDate   the end date of the period
     */
    void GetPayrollsForPeriod(Date startDate, Date endDate);
}
