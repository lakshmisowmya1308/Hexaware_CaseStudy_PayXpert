/**
 * This package contains the main class of the application.
 */

package com.hexaware.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hexaware.dao.EmployeeService;
import com.hexaware.dao.FinancialRecordService;
import com.hexaware.dao.PayrollService;
import com.hexaware.dao.TaxService;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.FinancialRecordException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.exception.PayrollGenerationException;
import com.hexaware.exception.TaxCalculationException;
import com.hexaware.model.Employee;
import com.hexaware.model.Payroll;

/**
 * Main class for generating reports and managing employee-related activities.
 * * Author: [Lakshmi Sowmya]
 */
public class ReportGenerator {
	public static void main(String[] args) throws ParseException, FinancialRecordException,InvalidInputException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeService e = new EmployeeService();
		PayrollService p = new PayrollService();
		TaxService t = new TaxService();
		FinancialRecordService f = new FinancialRecordService();
		Employee emp = new Employee();
		Payroll pr = new Payroll();
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome!!!");
		while(true) {
			System.out.println("Enter Your Choice: ");
			System.out.println("1. Employee Related Query");
			System.out.println("2. PayRoll Related Query");
			System.out.println("3. Tax Related Query");
			System.out.println("4. FinancialRecord Related Query");
			System.out.println("5. Exit");
			switch(s.nextInt()) {
			case 1 : System.out.println("What do you want to perform on Employee's data...");
					boolean c = true;
					while(c) {
						 System.out.println("Enter your Choice: ");
						 System.out.println("1. Get all employee records");
						 System.out.println("2. Get a Employee record");
						 System.out.println("3. Add Employee record");
						 System.out.println("4. Update employee record");
						 System.out.println("5. Remove employee record");
						 System.out.println("6. Exit");
						 switch(s.nextInt()) {
						 case 1: e.GetAllEmployees();
						 		 break;
						 case 2: System.out.print("Enter Your Employee ID: ");
							try {
								e.GetEmployeeById(s.nextInt());
							} catch (EmployeeNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						 		 break;
						 case 3: System.out.println("Enter details:-");
						 		 e.AddEmployee(details());
						 		 break;
						 case 4: System.out.println("Enter employee id: ");
						 		 int empid = s.nextInt();
						 		 System.out.println("Now enter new details...");
						 		 e.UpdateEmployee(details(), empid);
						 		 break;
						 case 5: System.out.println("Enter employee id: ");
						 		 e.RemoveEmployee(s.nextInt());
						 		 break;
						 case 6: System.out.println("Exiting...");
			                    c=false;
			                    break;
						 		 
						 }
					}
					break;
			case 2 : System.out.println("What do you want to perform on PayRoll's data...");
					boolean a = true;
					while(a) {
					 System.out.println("Enter your Choice: ");
					 System.out.println("1. Generate payroll record");
					 System.out.println("2. Get a payroll record");
					 System.out.println("3. Get Employee's payroll records");
					 System.out.println("4. Get payroll records within a period");
					 System.out.println("5. Exit");
					 switch(s.nextInt()) {
					 case 1: System.out.print("Enter Employee ID: ");
					 		 int eid = s.nextInt();
					 		 System.out.print("Enter Pay periods start date:");
					 		 Date psd = dateFormat.parse(s.next());
					 		 System.out.print("Enter Pay periods end date: ");
					 		 Date ped = dateFormat.parse(s.next());
					 		 System.out.println("Basic Salary: ");
					 		 pr.setBasicSalary(s.nextFloat());
					 		 System.out.println("OvertimePay: ");
					 		 pr.setOvertimePay(s.nextFloat());
					 		 System.out.println("Deductions : ");
					 		 pr.setDeductions(s.nextFloat());
						try {
							p.GeneratePayroll(pr, eid, psd, ped);
						} catch (PayrollGenerationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 	 break;
						 	 
					 case 2: System.out.print("Enter Payroll ID: ");
						 	 p.GetPayrollById(s.nextInt());
						 	 break;
						 	 
					 case 3: System.out.print("Enter Employee ID: ");
						 	 p.GetPayrollsForEmployee(s.nextInt());
						 	 break;
						 	 
					 case 4: System.out.println("Enter Start Date: ");
							 Date sd = dateFormat.parse(s.next());
							 System.out.println("Enter end Date: ");
							 Date ed = dateFormat.parse(s.next());
							 p.GetPayrollsForPeriod(sd, ed);
							 break;
					 case 5: System.out.println("Exiting...");
	                    a=false;
	                    break;
					 }
					}
					 break;
					 
			case 3 : System.out.println("What do you want to perform Tax data...");
					boolean b = true;
					while(b) {
					 System.out.println("Enter your Choice: ");
					 System.out.println("1. Calculate Tax");
					 System.out.println("2. Get a Tax record");
					 System.out.println("3. Get Employee's Tax records");
					 System.out.println("4. Get Tax records within a year");
					 System.out.println("5. Exit");
					 switch(s.nextInt()) {
					 case 1: System.out.print("Enter Employee ID: ");
					 		 int eid = s.nextInt();
					 		 System.out.print("Enter Tax year: ");
					 		 int ty = s.nextInt();
						try {
							t.CalculateTax(eid, ty);
						} catch (TaxCalculationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 	 break;
						 	 
					 case 2: System.out.print("Enter Tax ID: ");
						 	 t.GetTaxById(s.nextInt());
						 	 break;
						 	 
					 case 3: System.out.print("Enter Employee ID: ");
						 	 t.GetTaxesForEmployee(s.nextInt());
						 	 break;
						 	 
					 case 4: System.out.print("Enter Tax year: ");
					 		 int tyear = s.nextInt();
					 		 t.GetTaxesForYear(tyear);
							 break;
					 case 5: System.out.println("Exiting...");
	                    b=false;
	                    break;
					 }
					}
					 break;
			case 4 : System.out.println("What do you want to perform Financial Record's data...");
					boolean d = true;
					while(d) {
					 System.out.println("Enter your Choice: ");
					 System.out.println("1. Add Financial record");
					 System.out.println("2. Get a Financial record");
					 System.out.println("3. Get Employee's Financial records");
					 System.out.println("4. Get Financial record for a date");
					 System.out.println("5. Exit");
					 switch(s.nextInt()) {
					 case 1: System.out.print("Enter Employee ID: ");
					 		 int eid = s.nextInt();
					 		 System.out.print("Enter Description: ");
					 		 String des = s.next();
					 		 System.out.println("Enter Amount: ");
					 		 float amt = s.nextFloat();
					 		 System.out.println("Enter Record type: ");
					 		 String rt = s.next();
					 		 f.AddFinancialRecord(eid, des, amt, rt);
						 	 break;
						 	 
					 case 2: System.out.print("Enter Record ID: ");
						 	 f.GetFinancialRecordById(s.nextInt());
						 	 break;
						 	 
					 case 3: System.out.print("Enter Employee ID: ");
						 	 f.GetFinancialRecordsForEmployee(s.nextInt());
						 	 break;
						 	 
					 case 4: System.out.print("Enter Record Date: ");
					 		 f.GetFinancialRecordsForDate(dateFormat.parse(s.next()));
							 break;
					 case 5: System.out.println("Exiting...");
	                    d = false;
	                    break;
					 }
					}
					break;
			case 5: System.out.println("Exiting...");
            System.exit(0);
            break;
            default: System.out.println("Invalid input.");
					 
			}
		}
	}
	/**
     * Method to capture employee details.
     * @return Employee object with details.
     */
	public static Employee details() {
		Scanner s = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Employee emp = new Employee();
		System.out.print("Enter First Name: ");
		 emp.setFirstName(s.next());
		 System.out.print("Enter Last Name: ");
		 emp.setLastName(s.next());
		 System.out.print("Enter Date of Birth: ");
			try {
				emp.setDateOfBirth(dateFormat.parse(s.next()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		 System.out.print("Enter Gender: ");
		 emp.setGender(s.next());
		 System.out.print("Enter Email: ");
		 emp.setEmail(s.next());
		 System.out.print("Phone number: ");
		 emp.setPhoneNumber(s.nextLong());
		 System.out.print("Enter Address: ");
		 emp.setAddress(s.next());
		 System.out.print("Enter Position: ");
		 emp.setPosition(s.next());
		 System.out.println("Enter Joining Date: ");
		try {
			emp.setJoiningDate(dateFormat.parse(s.next()));
			System.out.println("Enter Termination Date: ");
			emp.setTerminationDate(dateFormat.parse(s.next()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return emp;
	}

}
