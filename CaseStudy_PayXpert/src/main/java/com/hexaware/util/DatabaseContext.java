/**
 * This package contains utility classes for processing payroll data.
 * It includes classes for database access, payroll calculations, and data validation.
 */
package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hexaware.exception.DatabaseConnectionException;

/**
 * Utility class for managing database connections.
 */
public class DatabaseContext {

    /**
     * Retrieves a database connection.
     *
     * @return a database connection
     * @throws DatabaseConnectionException if a database connection cannot be established
     */
    public static Connection getDBConn() throws DatabaseConnectionException {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CaseStudy", "root", "20kn1a4456");
        } catch (SQLException e) {
            throw new DatabaseConnectionException();
        }
        return con;
    }

    /**
     * Test method to check database connection.
     *
     * @param args command-line arguments
     * @throws DatabaseConnectionException if a database connection cannot be established
     */
    public static void main(String[] args) throws DatabaseConnectionException {
        System.out.println(getDBConn());
    }
}
