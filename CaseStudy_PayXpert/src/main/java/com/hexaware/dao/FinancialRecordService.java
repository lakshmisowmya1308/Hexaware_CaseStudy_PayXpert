package com.hexaware.dao;

import java.util.Date;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.FinancialRecordException;
import com.hexaware.service.IFinancialRecordService;
import com.hexaware.util.DatabaseContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Implements the IFinancialRecordService interface to provide functionalities related to financial record management.
 */
public class FinancialRecordService implements IFinancialRecordService{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt;

	 /**
     * Adds a financial record for an employee.
     * @param employeeId The ID of the employee.
     * @param description The description of the financial record.
     * @param amount The amount associated with the financial record.
     * @param recordType The type of the financial record.
     * @throws FinancialRecordException if an error occurs while adding the financial record.
     */
	@Override
	public void AddFinancialRecord(int employeeId, String description, float amount, String recordType) throws FinancialRecordException{
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    Date date = new Date();
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		try {
			ps = con.prepareStatement("select 1 from employee where EmployeeID in(?)");
			ps.setObject(1, employeeId);
			rs = ps.executeQuery();
			if(rs.next()) {
			}
			else {
				throw new EmployeeNotFoundException();
			}
			ps = con.prepareStatement("INSERT into FinancialRecord (EmployeeID,RecordDate,Description,Amount,RecordType)Values(?,?,?,?,?)");
			
			ps.setInt(1, employeeId);
			ps.setObject(2, sqlDate);
			ps.setString(3, description);
			ps.setFloat(4, amount);
			ps.setString(5, recordType);
			int r = ps.executeUpdate();
			if(r>0) {
				System.out.println("Record Successfully inserted ^-^");
				ps = con.prepareStatement("Select max(RecordID) from FinancialRecord");
				rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Here is your RecordID: "+rs.getInt("max(RecordID)"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(EmployeeNotFoundException emp) {
			emp.printStackTrace();
		}
		
	}

	/**
     * Retrieves a financial record by its ID.
     * @param recordId The ID of the financial record to retrieve.
     * @throws FinancialRecordException if an error occurs while retrieving the financial record.
     */
	@Override
	public void GetFinancialRecordById(int recordId) throws FinancialRecordException{
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("Select * from financialRecord where recordId = ?");
			ps.setObject(1, recordId);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("RecordID: "+rs.getInt("RecordID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nRecordDate: "+rs.getDate("RecordDate")+"\nDescription: "+rs.getString("Description")+"\nAmount: "+rs.getFloat("Amount")+"\nRecordType: "+rs.getString("RecordType"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Retrieves all financial records for a specific employee.
     * @param employeeId The ID of the employee.
     * @throws FinancialRecordException if an error occurs while retrieving the financial records.
     */
	@Override
	public void GetFinancialRecordsForEmployee(int employeeId) throws FinancialRecordException {
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
			ps = con.prepareStatement("Select * from financialRecord where employeeid = ?");
			ps.setObject(1, employeeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("RecordID: "+rs.getInt("RecordID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nRecordDate: "+rs.getDate("RecordDate")+"\nDescription: "+rs.getString("Description")+"\nAmount: "+rs.getFloat("Amount")+"\nRecordType: "+rs.getString("RecordType"));
				System.out.println("-----------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(EmployeeNotFoundException emp) {
			emp.printStackTrace();
		}
	}

	/**
     * Retrieves all financial records for a specific date.
     * @param recordDate The date for which financial records are to be retrieved.
     * @throws FinancialRecordException if an error occurs while retrieving the financial records.
     */
	@Override
	public void GetFinancialRecordsForDate(Date recordDate)throws FinancialRecordException {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("Select * from financialRecord where recordDate = ?");
			ps.setObject(1, recordDate);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("RecordID: "+rs.getInt("RecordID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nRecordDate: "+rs.getDate("RecordDate")+"\nDescription: "+rs.getString("Description")+"\nAmount: "+rs.getFloat("Amount")+"\nRecordType: "+rs.getString("RecordType"));
				System.out.println("-----------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
