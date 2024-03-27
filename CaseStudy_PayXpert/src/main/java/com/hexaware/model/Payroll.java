/*
 * Properties: PayrollID, EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary
 */

/**
 * Represents payroll details including various properties.
 */
package com.hexaware.model;

import java.util.Date;
/**
 * Represents an Payroll with various properties and methods.
 */
public class Payroll {
	private int PayrollID;
	private Date PayPeriodStartDate;
	private Date PayPeriodEndDate;
	private float BasicSalary;
	private float OvertimePay;
	private float Deductions;
	private float NetSalary;
	private int eid;
	Employee emp;
	
	/**
     * Default constructor for Payroll.
     */
	public Payroll() {
	}
	
	 /**
     * Constructs a Payroll object with specified parameters.
     * @param payrollID Unique identifier for the payroll
     * @param payPeriodStartDate Start date of the pay period
     * @param payPeriodEndDate End date of the pay period
     * @param basicSalary Basic salary of the employee for the pay period
     * @param overtimePay Overtime pay for the pay period
     * @param deductions Deductions from the salary for the pay period
     * @param netSalary Net salary after deductions for the pay period
     * @param emp Associated employee for the payroll
     */
	public Payroll(int payrollID, Date payPeriodStartDate, Date payPeriodEndDate, float basicSalary,
			float overtimePay, float deductions, float netSalary, Employee emp) {
		
		this.PayrollID = payrollID;
		this.PayPeriodStartDate = payPeriodStartDate;
		this.PayPeriodEndDate = payPeriodEndDate;
		this.BasicSalary = basicSalary;
		this.OvertimePay = overtimePay;
		this.Deductions = deductions;
		this.NetSalary = netSalary;
		this.emp = emp;
	}

	/**
     * Getters and setters of the Payroll.
     * 
     * */
	
	public int getPayrollID() {
		return PayrollID;
	}

	public void setPayrollID(int payrollID) {
		PayrollID = payrollID;
	}

	public Date getPayPeriodStartDate() {
		return PayPeriodStartDate;
	}

	public void setPayPeriodStartDate(Date payPeriodStartDate) {
		PayPeriodStartDate = payPeriodStartDate;
	}

	public Date getPayPeriodEndDate() {
		return PayPeriodEndDate;
	}

	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		PayPeriodEndDate = payPeriodEndDate;
	}

	public float getBasicSalary() {
		return BasicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		BasicSalary = basicSalary;
	}

	public float getOvertimePay() {
		return OvertimePay;
	}

	public void setOvertimePay(float overtimePay) {
		OvertimePay = overtimePay;
	}

	public float getDeductions() {
		return Deductions;
	}

	public void setDeductions(float deductions) {
		Deductions = deductions;
	}

	public float getNetSalary() {
		return NetSalary;
	}

	public void setNetSalary(float netSalary) {
		NetSalary = netSalary;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public int getEid() {
		return eid;
	}

	public void setEid(int empid) {
		this.eid = empid;
	}
	
	/**
     * Returns a string representation of the Payroll object.
     * @return String representation of Payroll
     */
	@Override
	public String toString() {
		return "\nPayRoll [\nPayrollID=" + PayrollID + ", \nPayPeriodStartDate=" + PayPeriodStartDate
				+ ", \nPayPeriodEndDate=" + PayPeriodEndDate + ", \nBasicSalary=" + BasicSalary + ", \nOvertimePay="
				+ OvertimePay + ", \nDeductions=" + Deductions + ", \nNetSalary=" + NetSalary + emp.toString()
				+ "]";
	}
}
