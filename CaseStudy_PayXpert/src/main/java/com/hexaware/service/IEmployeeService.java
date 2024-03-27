package com.hexaware.service;

import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.model.Employee;

/**
 * Interface for managing employee-related operations.
 */
public interface IEmployeeService {

    /**
     * Retrieves an employee by their ID.
     *
     * @param employeeId the ID of the employee to retrieve
     * @throws EmployeeNotFoundException if the employee with the specified ID is not found
     */
    void GetEmployeeById(int employeeId) throws EmployeeNotFoundException;

    /**
     * Retrieves all employees.
     */
    void GetAllEmployees();

    /**
     * Adds a new employee.
     *
     * @param emp the employee to add
     */
    void AddEmployee(Employee emp);

    /**
     * Updates an existing employee.
     *
     * @param emp         the updated employee data
     * @param employeeId  the ID of the employee to update
     */
    void UpdateEmployee(Employee emp, int employeeId);

    /**
     * Removes an employee by their ID.
     *
     * @param employeeId the ID of the employee to remove
     */
    void RemoveEmployee(int employeeId);
}
