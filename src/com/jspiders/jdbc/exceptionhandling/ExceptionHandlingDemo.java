package com.jspiders.jdbc.exceptionhandling;

import java.sql.*;

public class ExceptionHandlingDemo {
    public static Connection getDBConnection() {
        Connection con = null;
        String dbUrl = "jdbc:mysql://localhost:3306/appUsers";
        String user = "root";
        String password = "Root@#7382";

        try
        {
            con = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("Connected to appUsers-db successfully");
        }
        catch(SQLException e)
        {
            System.err.println("Error while connecting to the database : " + e.getMessage());
            throw new DBConnectionException(e.getMessage());
        }
        return con;
    }
    public static void addUsers(){
        String insertSql = "insert into appUsers.users values (0,'Transa','987654325','pass789');";

        try
        {
            Connection con = getDBConnection();
            Statement sm1 = con.createStatement();
            int rowsUpdated = sm1.executeUpdate(insertSql);
            System.out.println("Rows updated: " + rowsUpdated);
        }
        catch(SQLSyntaxErrorException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }
        catch(SQLException e)
        {
            throw new DuplicatePhoneNumberException("User with mobile number already exists in the database");
        }

    }
    public static void main(String[] args) {
        System.out.println("Program starts...");
        addUsers();
        System.out.println("Program ends...");

    }
}
