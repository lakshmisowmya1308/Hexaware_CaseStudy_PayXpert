/*
 * Properties: RecordID, EmployeeID, RecordDate, Description, Amount, RecordType
 */
/**
 * Represents financial records with various properties.
 */
package com.hexaware.model;

import java.util.Date;
/**
 * Represents an FinancialRecord with various properties and methods.
 */
public class FinancialRecord {
	private int RecordID;
	private Date RecordDate;
	private String Description;
	private float Amount;
	private String RecordType;
	Employee emp;
	
	 /**
     * Default constructor for FinancialRecord.
     */
	public FinancialRecord() {
	}
	
	/**
     * Constructs a FinancialRecord object with specified parameters.
     * @param recordID Unique identifier for the financial record
     * @param recordDate Date of the financial record
     * @param description Description of the financial record
     * @param amount Amount associated with the financial record
     * @param recordType Type of the financial record
     * @param emp Associated employee for the financial record
     */
	public FinancialRecord(int recordID, Date recordDate, String description, float amount, String recordType,
			Employee emp) {
		this.RecordID = recordID;
		this.RecordDate = recordDate;
		this.Description = description;
		this.Amount = amount;
		this.RecordType = recordType;
		this.emp = emp;
	}
	
    /** Getters and Setters for financial record.
     *
     */
	
	public int getRecordID() {
		return RecordID;
	}
	public void setRecordID(int recordID) {
		RecordID = recordID;
	}
	public Date getRecordDate() {
		return RecordDate;
	}
	public void setRecordDate(Date recordDate) {
		RecordDate = recordDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getRecordType() {
		return RecordType;
	}
	public void setRecordType(String recordType) {
		RecordType = recordType;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	/**
     * Returns a string representation of the FinancialRecord object.
     * @return String representation of FinancialRecord
     */
	@Override
	public String toString() {
		return "\nFinancialRecord [\nRecordID=" + RecordID + ", \nRecordDate=" + RecordDate + ", \nDescription=" + Description
				+ ", \nAmount=" + Amount + ", \nRecordType=" + RecordType +emp.toString() + "]";
	}
	
	
}
