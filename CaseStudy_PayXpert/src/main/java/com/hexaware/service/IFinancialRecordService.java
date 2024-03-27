package com.hexaware.service;

import java.util.Date;

import com.hexaware.exception.FinancialRecordException;

/**
 * Interface for managing financial record-related operations.
 */
public interface IFinancialRecordService {

    /**
     * Adds a financial record for an employee.
     *
     * @param employeeId  the ID of the employee
     * @param description the description of the financial record
     * @param amount      the amount of the financial record
     * @param recordType  the type of the financial record
     * @throws FinancialRecordException if an error occurs while adding the financial record
     */
    void AddFinancialRecord(int employeeId, String description, float amount, String recordType) throws FinancialRecordException;

    /**
     * Retrieves a financial record by its ID.
     *
     * @param recordId the ID of the financial record to retrieve
     * @throws FinancialRecordException if the financial record with the specified ID is not found
     */
    void GetFinancialRecordById(int recordId) throws FinancialRecordException;

    /**
     * Retrieves all financial records for a specific employee.
     *
     * @param employeeId the ID of the employee
     * @throws FinancialRecordException if an error occurs while retrieving the financial records
     */
    void GetFinancialRecordsForEmployee(int employeeId) throws FinancialRecordException;

    /**
     * Retrieves financial records for a specific date.
     *
     * @param recordDate the date for which to retrieve financial records
     * @throws FinancialRecordException if an error occurs while retrieving the financial records
     */
    void GetFinancialRecordsForDate(Date recordDate) throws FinancialRecordException;
}
