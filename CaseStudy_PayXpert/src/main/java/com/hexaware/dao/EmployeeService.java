/**
 * This package contains classes that provide data access functionality.
 */

package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.model.Employee;
import com.hexaware.service.IEmployeeService;
import com.hexaware.util.DatabaseContext;
/**
 * Implements the IEmployeeService interface to provide functionalities related to employee management.
 */
public class EmployeeService implements IEmployeeService{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt;
	
	/**
     * Retrieves employee details by ID.
     * @param employeeId The ID of the employee to retrieve.
     * @throws EmployeeNotFoundException if the employee with the given ID is not found.
     */
	@Override
	public void GetEmployeeById(int employeeId) throws EmployeeNotFoundException {
	    try {
	        try {
				con = DatabaseContext.getDBConn();
			} catch (DatabaseConnectionException e) {
				e.printStackTrace();
			}
	        ps = con.prepareStatement("SELECT * FROM employee WHERE employeeid = ?");
	        ps.setObject(1, employeeId);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            System.out.println("\nEmployeeID: " + rs.getInt("EmployeeID") +
	                    "\nFirst name: " + rs.getString("FirstName") +
	                    "\nLastName: " + rs.getString("LastName") +
	                    "\nDate of birth: " + rs.getDate("DateOfBirth") +
	                    "\nGender: " + rs.getString("Gender") +
	                    "\nEmail: " + rs.getString("Email") +
	                    "\nPhone Number: " + rs.getLong("PhoneNumber") +
	                    "\nAddress: " + rs.getString("Address") +
	                    "\nPosition = " + rs.getString("Position") +
	                    "\nJoining Date: " + rs.getDate("JoiningDate") +
	                    "\nTermination Date: " + rs.getDate("TerminationDate"));
	        } else {
	            throw new EmployeeNotFoundException();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	 /**
     * Retrieves details of all employees.
     */
	@Override
	public void GetAllEmployees() {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			ps = con.prepareStatement("Select * from employee");
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("\nEmployeeID: "+rs.getInt("EmployeeID")+"\nFirst name: "+
			rs.getString("FirstName")+"\nLastName: "+rs.getString("LastName")+"\nDate of birth: "+rs.getDate("DateOfBirth")
			+"\nGender: "+rs.getString("Gender")+"\nEmail: "+rs.getString("Email")+"\nPhone Number: "+rs.getLong("PhoneNumber")
			+"\nAddress: "+rs.getString("Address")+"\nPosition = "+rs.getString("Position")+"\nJoining Date: "+rs.getDate("JoiningDate")
			+"\nTermination Date: "+rs.getDate("TerminationDate"));
				System.out.println("-----------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Adds a new employee.
     * @param emp The Employee object representing the new employee.
     */
	@Override
	public void AddEmployee(Employee emp) {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("Insert into Employee (FirstName,LastName,DateOfBirth, Gender,Email,PhoneNumber,Address,Position,JoiningDate,TerminationDate) Values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setObject(3,emp.getDateOfBirth());
			ps.setString(4, emp.getGender());
			ps.setString(5, emp.getEmail());
			ps.setLong(6,emp.getPhoneNumber());
			ps.setString(7, emp.getAddress());
			ps.setString(8, emp.getPosition());
			ps.setObject(9, emp.getJoiningDate());
			ps.setObject(10, emp.getTerminationDate());




			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Employee record created successfully");
				ps = con.prepareStatement("Select max(EmployeeID) from employee");
				rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Here is your EmployeeID: "+rs.getInt("max(EmployeeID)"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace(	);
		}
		
	}
	
	/**
     * Updates an existing employee.
     * @param emp The Employee object representing the updated employee details.
     * @param employeeID The ID of the employee to be updated.
     */
	@Override
	public void UpdateEmployee(Employee emp, int employeeID) {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("select 1 from employee where EmployeeID in(?)");
			ps.setObject(1, employeeID);
			rs = ps.executeQuery();
			if(rs.next()) {
			}
			else {
				throw new EmployeeNotFoundException();
			}
			ps = con.prepareStatement("UPDATE Employee SET FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, " +
                    "Email = ?, PhoneNumber = ?, Address = ?, Position = ?, JoiningDate = ?, TerminationDate = ? " +
                    "WHERE EmployeeID = ?");
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setObject(3,emp.getDateOfBirth());
			ps.setString(4, emp.getGender());
			ps.setString(5, emp.getEmail());
			ps.setLong(6,emp.getPhoneNumber());
			ps.setString(7, emp.getAddress());
			ps.setString(8, emp.getPosition());
			ps.setObject(9, emp.getJoiningDate());
			ps.setObject(10, emp.getTerminationDate());
			ps.setObject(11, employeeID);
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Employee record Updated successfully");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(EmployeeNotFoundException i) {
			i.printStackTrace();
		}
	}
	
	/**
     * Removes an employee.
     * @param employeeId The ID of the employee to be removed.
     */
	@Override
	public void RemoveEmployee(int employeeId) {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("select 1 from employee where EmployeeID in(?)");
			ps.setObject(1, employeeId);
			rs = ps.executeQuery();
			if(rs.next()) {
			}
			else {
				throw new EmployeeNotFoundException();
			}
			ps = con.prepareStatement("delete from FinancialRecord where EmployeeID = ?");
			ps.setObject(1, employeeId);
			ps.executeUpdate();
			ps = con.prepareStatement("delete from tax where EmployeeID = ?");
			ps.setObject(1, employeeId);
			ps.executeUpdate();
			ps = con.prepareStatement("delete from payroll where EmployeeID = ?");
			ps.setObject(1, employeeId);
			ps.executeUpdate();
			ps = con.prepareStatement("delete from employee where EmployeeID = ?");
			ps.setObject(1, employeeId);
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Employee record deleted successfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(EmployeeNotFoundException emp) {
			emp.printStackTrace();
		}
		
	}
	
}
