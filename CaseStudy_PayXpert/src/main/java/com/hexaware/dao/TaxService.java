package com.hexaware.dao;

import com.hexaware.service.ITaxService;
import com.hexaware.util.DatabaseContext;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.exception.*;

/**
 * Implements the ITaxService interface to provide functionalities related to tax management.
 */
public class TaxService implements ITaxService{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt;
	
	
	/**
     * Calculates tax for an employee for a specific tax year.
     * @param employeeId The ID of the employee.
     * @param taxYear The tax year.
     * @throws TaxCalculationException if tax calculation encounters an error.
     */
	@Override
	public void CalculateTax(int employeeId, int taxYear) throws TaxCalculationException {
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
			ps = con.prepareStatement("Select sum(basicSalary) from payroll where employeeId = ? and YEAR(PayPeriodStartDate)= ? and YEAR(PayPeriodEndDate)= ?");
			ps.setObject(1,employeeId);
			ps.setObject(2,taxYear);
			ps.setObject(3,taxYear);
			rs = ps.executeQuery();
			float taxableIncome;
			float taxAmount;
			if(rs.next()) {
				taxableIncome = rs.getFloat("sum(basicSalary)");
				taxAmount = taxableIncome*0.15f;
				ps = con.prepareStatement("INSERT INTO Tax(EmployeeID, TaxYear, TaxableIncome, TaxAmount) VALUES (?,?,?,?)");
				ps.setInt(1, employeeId);
				ps.setInt(2, taxYear);
				ps.setFloat(3, taxableIncome);
				ps.setFloat(4, taxAmount);
				int r = ps.executeUpdate();
				if(r>0) {
					System.out.println("Here is your Tax amount: "+taxAmount+"\n Recorded Successfully.");
					ps = con.prepareStatement("Select max(TaxID) from Tax");
					rs = ps.executeQuery();
					if(rs.next()) {
						System.out.println("Here is your TaxID: "+rs.getInt("max(TaxID)"));
					}
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(EmployeeNotFoundException emp) {
			emp.printStackTrace();
		}
	}

	/**
     * Retrieves tax details by tax ID.
     * @param taxId The ID of the tax to retrieve.
     */
	@Override
	public void GetTaxById(int taxId) {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("Select * from Tax where taxid = ?");
			ps.setObject(1,taxId);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("Tax: \nTaxId: "+rs.getInt("TaxID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nTaxYear: "+rs.getInt("TaxYear")+"\nTaxableIncome: "+rs.getFloat("TaxableIncome")+"\nTaxAmount: "+rs.getFloat("TaxAmount"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	 /**
     * Retrieves all taxes for a specific employee.
     * @param employeeId The ID of the employee.
     */
	@Override
	public void GetTaxesForEmployee(int employeeId) {
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
			ps = con.prepareStatement("Select * from Tax where employeeId = ?");
			ps.setObject(1,employeeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("TaxId: "+rs.getInt("TaxID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nTaxYear: "+rs.getInt("TaxYear")+"\nTaxableIncome: "+rs.getFloat("TaxableIncome")+"\nTaxAmount: "+rs.getFloat("TaxAmount"));
				System.out.println("-----------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(EmployeeNotFoundException emp) {
			emp.printStackTrace();
		}
	}

	 /**
     * Retrieves all taxes for a specific tax year.
     * @param taxYear The tax year.
     */
	@Override
	public void GetTaxesForYear(int taxYear) {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("Select * from Tax where TaxYear = ?");
			ps.setObject(1,taxYear);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("TaxId: "+rs.getInt("TaxID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nTaxYear: "+rs.getInt("TaxYear")+"\nTaxableIncome: "+rs.getFloat("TaxableIncome")+"\nTaxAmount: "+rs.getFloat("TaxAmount"));
				System.out.println("-----------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//testcase3 class
	/**
     * Calculates the total tax amount for an employee.
     * @param eid The ID of the employee.
     * @return The total tax amount for the employee.
     */
	public float TaxCalculation(int eid) {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("select 1 from employee where EmployeeID in(?)");
			ps.setObject(1, eid);
			rs = ps.executeQuery();
			if(rs.next()) {
			}
			else {
				throw new EmployeeNotFoundException();
			}
			ps =  con.prepareStatement("select EmployeeID from (select EmployeeID, sum(NetSalary) as TotalNetSalary from Payroll group by EmployeeID) as PayrollSummary where TotalNetSalary = (select max(TotalNetSalary) from (select sum(NetSalary) as TotalNetSalary from Payroll group by EmployeeID) as EmployeePayrollSum)");
			rs = ps.executeQuery();
			int empid = 100;
			if(rs.next()) {
				empid = rs.getInt("EmployeeID");
			}
			if(empid != eid) {
				return 0.0f;
			}
			ps = con.prepareStatement("select sum(TaxAmount) from tax where EmployeeID=?");
			ps.setObject(1,empid);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getFloat("sum(TaxAmount)");
			}
		}catch(SQLException | EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return 0.0f;
	}

}
