/*
 Properties: TaxID, EmployeeID, TaxYear, TaxableIncome, TaxAmount
 */
/**
 * Represents tax details including various properties.
 */
package com.hexaware.model;
/**
 * Represents an Tax with various properties and methods.
 */
public class Tax {
	private int TaxID;
	private int TaxYear;
	private float TaxableIncome;
	private float TaxAmount;
	Employee emp;
	
	 /**
     * Default constructor for Tax.
     */
	public Tax() {
	}
	
	 /**
     * Constructs a Tax object with specified parameters.
     * @param taxID Unique identifier for the tax
     * @param taxYear Year of the tax
     * @param taxableIncome Taxable income for the tax year
     * @param taxAmount Amount of tax
     * @param emp Associated employee for the tax
     */
	public Tax(int taxID, int taxYear, float taxableIncome, float taxAmount, Employee emp) {
		
		this.TaxID = taxID;
		this.TaxYear = taxYear;
		this.TaxableIncome = taxableIncome;
		this.TaxAmount = taxAmount;
		this.emp = emp;
	}
	
    /** Getters and Setters of the tax.
    * 
    */
	
	public int getTaxID() {
		return TaxID;
	}
	public void setTaxID(int taxID) {
		TaxID = taxID;
	}
	public int getTaxYear() {
		return TaxYear;
	}
	public void setTaxYear(int taxYear) {
		TaxYear = taxYear;
	}
	public float getTaxableIncome() {
		return TaxableIncome;
	}
	public void setTaxableIncome(float taxableIncome) {
		TaxableIncome = taxableIncome;
	}
	public float getTaxAmount() {
		return TaxAmount;
	}
	public void setTaxAmount(float taxAmount) {
		TaxAmount = taxAmount;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	/**
     * Returns a string representation of the Tax object.
     * @return String representation of Tax
     */
	@Override
	public String toString() {
		return "\nTax [\nTaxID=" + TaxID + ", \nTaxYear=" + TaxYear + ", \nTaxableIncome=" + TaxableIncome + ", \nTaxAmount="
				+ TaxAmount +  emp.toString() + "]";
	}
	
}
