/*
 Properties: EmployeeID, FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate
 Methods: CalculateAge()
*/
/**
 * Represents an employee with various properties and methods.
 */
package com.hexaware.model;

import java.util.Date;
/**
 * Represents an Employee with various properties and methods.
 */
public class Employee {
	private int EmployeeID;
	private String FirstName;
	private String LastName;
	private Date DateOfBirth;
	private String Gender;
	private String Email;
	private long PhoneNumber;
	private String Address;
	private String Position;
	private Date JoiningDate;
	private Date TerminationDate;
	
	
	 /**
     * Constructs an Employee object with specified parameters.
     * @param EmployeeID Unique identifier for the employee
     * @param FirstName First name of the employee
     * @param LastName Last name of the employee
     * @param DateOfBirth Date of birth of the employee
     * @param Gender Gender of the employee
     * @param Email Email address of the employee
     * @param PhoneNumber Phone number of the employee
     * @param Address Address of the employee
     * @param Position Position/title of the employee
     * @param JoiningDate Date when the employee joined the company
     * @param TerminationDate Date when the employee's employment was terminated
     */
	public Employee(int EmployeeID, String FirstName, String LastName, Date	DateOfBirth, String Gender, String Email, long PhoneNumber, String Address, String Position,Date JoiningDate, Date TerminationDate) {
		this.EmployeeID = EmployeeID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.DateOfBirth = DateOfBirth;
		this.Gender = Gender;
		this.Email = Email;
		this.PhoneNumber = PhoneNumber;
		this.Address = Address;
		this.Position = Position;
		this.JoiningDate = JoiningDate;
		this.TerminationDate = TerminationDate;
	}
	
	/**
     * Default constructor for Employee.
     */
	public Employee() {
		
	}
	
	/**
     * Getters and setters of the employee.
     * 
     * */
	
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public Date getJoiningDate() {
		return JoiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		JoiningDate = joiningDate;
	}
	public Date getTerminationDate() {
		return TerminationDate;
	}
	public void setTerminationDate(Date terminationDate) {
		TerminationDate = terminationDate;
	}
	
	/**
     * Calculate the age of the employee based on their date of birth.
     */
		public void CalculateAge() {
			//DateTime today = DateTime.Today;
            //int age = today.Year - DateOfBirth.Year;
            //if (DateOfBirth.Date > today.AddYears(-age)) age--;
            //return age;
		}
	
		
		/**
	     * Returns a string representation of the Employee object.
	     * @return String representation of Employee
	     */
	@Override
	public String toString() {
		return "\nEmployee [\nEmployeeID=" + EmployeeID + ", \nFirstName=" + FirstName + ", \nLastName=" + LastName
				+ ", \nDateOfBirth=" + DateOfBirth + ", \nGender=" + Gender + ", \nEmail=" + Email + ", \nPhoneNumber="
				+ PhoneNumber + ", \nAddress=" + Address + ", \nPosition=" + Position + ", \nJoiningDate=" + JoiningDate
				+ ", \nTerminationDate=" + TerminationDate + "]";
	}
	
	
	
}
