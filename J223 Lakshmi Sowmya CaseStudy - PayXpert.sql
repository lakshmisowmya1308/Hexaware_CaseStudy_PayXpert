-- J223 LAKSHMI SOWMYA TANIKELLA
-- CASE STUDY - PAYXPERT, The Payroll Management System

create database CaseStudy;
use CaseStudy;
-- drop database casestudy;
-- SQL Tables:
create table employee(
	EmployeeID int AUTO_INCREMENT, 
	FirstName varchar(20), 
	LastName varchar(20),
	DateOfBirth date, 
	Gender varchar(1),
	Email varchar(50),
	PhoneNumber bigint,
	Address varchar(50),
	Position varchar(15), 
	JoiningDate date,
	TerminationDate date, 
	primary key (EmployeeID),
    unique (phonenumber, email)
)AUTO_INCREMENT = 1001;

create table Payroll(
	PayrollID int  AUTO_INCREMENT,
	EmployeeID int,
	PayPeriodStartDate date,
	PayPeriodEndDate date,
	BasicSalary float,
	OvertimePay float,
	Deductions float,
	NetSalary float,
	primary key(PayrollID),
	foreign key(EmployeeID) REFERENCES employee(EmployeeID)
)AUTO_INCREMENT = 2001;

create table Tax(
	TaxID int  AUTO_INCREMENT,
	EmployeeID int,
	TaxYear int,
	TaxableIncome float,
	TaxAmount float,
	primary key(TaxID),
	foreign key(EmployeeID) references employee(EmployeeID)
)AUTO_INCREMENT = 3001;

create table FinancialRecord(
	RecordID int  AUTO_INCREMENT,
	EmployeeID int,
	RecordDate date,
	Description varchar(100),
	Amount float,
	RecordType varchar(15),
	primary key(RecordID),
	foreign key(EmployeeID) references employee(EmployeeID)
)AUTO_INCREMENT = 4001;

-- Inserting records into the Employee table with termination dates
INSERT INTO Employee (FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate)
VALUES ('Alice', 'Johnson', '1992-08-10', 'F', 'alice.johnson@example.com', 1234567891, '789 Oak St', 'Sales Associate', '2023-05-20', '2024-02-28'),
       ('Bob', 'Smith', '1988-03-25', 'M', 'bob.smith@example.com', 9876543211, '456 Maple St', 'Engineer', '2023-08-15', '2024-01-15'),
       ('Emily', 'Davis', '1995-11-30', 'F', 'emily.davis@example.com', 1112223334, '101 Pine St', 'Specialist', '2023-10-01', '2023-12-31'),
       ('Michael', 'Brown', '1980-12-05', 'M', 'michael.brown@example.com', 2223334445, '222 Cedar St', 'Senior Analyst', '2023-07-10', '2023-11-30'),
       ('Sophia', 'Martinez', '1987-06-15', 'F', 'sophia.martinez@example.com', 3334445556, '333 Elm St', 'HR Manager', '2023-09-05', '2024-03-15');


-- Inserting records into the Payroll table
INSERT INTO Payroll (EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary)
VALUES (1001, '2024-03-01', '2024-03-15', 2000.00, 100.00, 50.00, 2050.00),
       (1002, '2024-03-01', '2024-03-15', 1800.00, 50.00, 30.00, 1820.00),
       (1003, '2024-03-01', '2024-03-15', 2200.00, 150.00, 70.00, 2280.00),
       (1004, '2024-03-01', '2024-03-15', 2100.00, 100.00, 60.00, 2140.00),
       (1005, '2024-03-01', '2024-03-15', 1900.00, 75.00, 40.00, 1935.00),
       (1001, '2024-03-16', '2024-03-31', 2000.00, 120.00, 60.00, 2060.00),
       (1002, '2024-03-16', '2024-03-31', 1800.00, 60.00, 35.00, 1825.00),
       (1003, '2024-03-16', '2024-03-31', 2200.00, 200.00, 90.00, 2310.00),
       (1004, '2024-03-16', '2024-03-31', 2100.00, 150.00, 80.00, 2170.00),
       (1005, '2024-03-16', '2024-03-31', 1900.00, 100.00, 50.00, 1950.00);

-- Inserting records into the Tax table
INSERT INTO Tax (EmployeeID, TaxYear, TaxableIncome, TaxAmount)
VALUES (1001, 2024, 24000.00, 4800.00),
       (1002, 2024, 21600.00, 4320.00),
       (1003, 2024, 26400.00, 5280.00),
       (1004, 2024, 25200.00, 5040.00),
       (1005, 2024, 22800.00, 4560.00),
       (1001, 2024, 24800.00, 4960.00),
       (1002, 2024, 22200.00, 4440.00),
       (1003, 2024, 27200.00, 5440.00),
       (1004, 2024, 26000.00, 5200.00),
       (1005, 2024, 23600.00, 4720.00);

-- Inserting records into the FinancialRecord table
INSERT INTO FinancialRecord (EmployeeID, RecordDate, Description, Amount, RecordType)
VALUES (1001, '2024-03-15', 'Bonus', 500.00, 'Income'),
       (1002, '2024-03-15', 'Travel Expense', 50.00, 'Expense'),
       (1003, '2024-03-15', 'Team Lunch', 200.00, 'Expense'),
       (1004, '2024-03-15', 'Training Expense', 100.00, 'Expense'),
       (1005, '2024-03-15', 'Bonus', 400.00, 'Income'),
       (1001, '2024-03-31', 'Travel Expense', 100.00, 'Expense'),
       (1002, '2024-03-31', 'Team Lunch', 150.00, 'Expense'),
       (1003, '2024-03-31', 'Bonus', 600.00, 'Income'),
       (1004, '2024-03-31', 'Training Expense', 120.00, 'Expense'),
       (1005, '2024-03-31', 'Travel Expense', 80.00, 'Expense');

select * from employee;