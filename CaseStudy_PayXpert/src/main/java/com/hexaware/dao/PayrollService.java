
/**
 * This package contains classes that handle data access operations.
 */
package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.PayrollGenerationException;
import com.hexaware.model.Payroll;
import com.hexaware.service.IPayrollService;
import com.hexaware.util.DatabaseContext;


/**
 * Implements the IPayrollService interface to provide functionalities related to payroll management.
 */
public class PayrollService implements IPayrollService{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt;

	
	 /**
     * Generates payroll for an employee within a specified period.
     * @param p The Payroll object representing the payroll details.
     * @param employeeId The ID of the employee for whom payroll is generated.
     * @param startDate The start date of the payroll period.
     * @param endDate The end date of the payroll period.
     * @throws PayrollGenerationException if an error occurs during payroll generation.
     */
	@Override
	public void GeneratePayroll(Payroll p,int employeeId, Date startDate, Date endDate) throws PayrollGenerationException{
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
			float BasicSalary = p.getBasicSalary();
			float OverTimePay = p.getOvertimePay();
			float Deductions = p.getDeductions();
			float NetSalary = BasicSalary+OverTimePay-Deductions;
			ps = con.prepareStatement("Insert into payroll (EmployeeID,PayPeriodStartDate,PayPeriodEndDate,BasicSalary,OvertimePay,Deductions,NetSalary) values(?,?,?,?,?,?,?)");
			ps.setInt(1, employeeId);
			ps.setObject(2,startDate);
			ps.setObject(3,endDate);
			ps.setFloat(4, BasicSalary);
			ps.setFloat(5, OverTimePay);
			ps.setFloat(6, Deductions);
			ps.setFloat(7, NetSalary);
			int r = ps.executeUpdate();
			if(r>0) {
				System.out.println("Payroll Generated Successfully");
				ps = con.prepareStatement("Select max(PayrollID) from payroll");
				rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Here is your PayrollID: "+rs.getInt("max(PayrollID)"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(EmployeeNotFoundException emp) {
			emp.printStackTrace();
		}
	}

	/**
     * Retrieves payroll details by payroll ID.
     * @param payrollId The ID of the payroll to retrieve.
     */
	@Override
	public Payroll GetPayrollById(int payrollId){
		Payroll payroll = null;
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("Select * from Payroll where payrollId = ?");
			ps.setObject(1, payrollId);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("\nPayrollID: "+rs.getInt("PayrollID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nPayPeriodStartDate: "+rs.getDate("PayPeriodStartDate")+"\nPayPeriodEndDate: "+rs.getDate("PayPeriodEndDate")+"\nBasicSalary: "+rs.getInt("BasicSalary")+"\nOvertimePay: "+rs.getInt("OvertimePay")+"\nDeductions: "+rs.getInt("Deductions")+"\nNetSalary: "+rs.getInt("NetSalary"));
				payroll = new Payroll();
	            payroll.setPayrollID(rs.getInt("PayrollID"));
	            payroll.setEid(rs.getInt("EmployeeID"));
	            payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	            payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	            payroll.setBasicSalary(rs.getFloat("BasicSalary"));
	            payroll.setOvertimePay(rs.getFloat("OvertimePay"));
	            payroll.setDeductions(rs.getFloat("Deductions"));
	            payroll.setNetSalary(rs.getFloat("NetSalary"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return payroll;
		
	}

	 /**
     * Retrieves all payrolls for a specific employee.
     * @param employeeId The ID of the employee.
     */
	@Override
	public void GetPayrollsForEmployee(int employeeId){
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
			ps = con.prepareStatement("Select * from Payroll where employeeid = ?");
			ps.setObject(1, employeeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("\nPayrollID: "+rs.getInt("PayrollID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nPayPeriodStartDate: "+rs.getDate("PayPeriodStartDate")+"\nPayPeriodEndDate: "+rs.getDate("PayPeriodEndDate")+"\nBasicSalary: "+rs.getInt("BasicSalary")+"\nOvertimePay: "+rs.getInt("OvertimePay")+"\nDeductions: "+rs.getInt("Deductions")+"\nNetSalary: "+rs.getInt("NetSalary"));
				System.out.println("-----------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(EmployeeNotFoundException emp) {
			emp.printStackTrace();
		}
	}

	/**
     * Retrieves all payrolls within a specified period.
     * @param startDate The start date of the period.
     * @param endDate The end date of the period.
     */
	@Override
	public void GetPayrollsForPeriod(Date startDate, Date endDate){
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			ps = con.prepareStatement("Select * from Payroll where PayPeriodStartDate >= ? and PayPeriodStartDate <= ?");
			ps.setObject(1, startDate);
			ps.setObject(2, endDate);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("\nPayrollID: "+rs.getInt("PayrollID")+"\nEmployeeID: "+rs.getInt("EmployeeID")+"\nPayPeriodStartDate: "+rs.getDate("PayPeriodStartDate")+"\nPayPeriodEndDate: "+rs.getDate("PayPeriodEndDate")+"\nBasicSalary: "+rs.getInt("BasicSalary")+"\nOvertimePay: "+rs.getInt("OvertimePay")+"\nDeductions: "+rs.getInt("Deductions")+"\nNetSalary: "+rs.getInt("NetSalary"));
				System.out.println("-----------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//testcase-1 class
	 /**
     * Calculates the gross salary for an employee.
     * @param eid The ID of the employee.
     * @return The gross salary of the employee.
     */
	public float CalculateGrossSalary(int eid) {
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
			ps = con.prepareStatement("select sum(BasicSalary)+sum(OvertimePay) g from payroll where EmployeeID=?");
			ps.setObject(1,eid);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getFloat("g");
			}
		}catch(SQLException | EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return 0.0f;
	}
	
	//testcase-2 class
	/**
     * Calculates the net salary after deductions for a payroll.
     * @param p The Payroll object representing payroll details.
     * @return The net salary after deductions.
     */
	public float CalculateNetSalaryAfterDeductions(Payroll p) {
		try {
			con = DatabaseContext.getDBConn();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("select NetSalary from payroll where PayrollID=?");
			ps.setObject(1,p.getPayrollID());
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getFloat("NetSalary");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0.0f;
	}
	
	public List<Payroll> GetPayrollForAllEmployees() {
	    List<Payroll> payrollList = new ArrayList<>();
	    try {
	        con = DatabaseContext.getDBConn();
	        ps = con.prepareStatement("SELECT * FROM Payroll");
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            Payroll payroll = new Payroll();
	            payroll.setPayrollID(rs.getInt("PayrollID"));
	            payroll.setEid(rs.getInt("EmployeeID"));
	            payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	            payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	            payroll.setBasicSalary(rs.getFloat("BasicSalary"));
	            payroll.setOvertimePay(rs.getFloat("OvertimePay"));
	            payroll.setDeductions(rs.getFloat("Deductions"));
	            payroll.setNetSalary(rs.getFloat("NetSalary"));
	            
	            payrollList.add(payroll);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (DatabaseConnectionException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return payrollList;
	}

}

