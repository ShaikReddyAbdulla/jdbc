package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
    public static void main(String[] args) {
        System.out.println("Program starts...");
        String url = "jdbc:mysql://localhost:3306/appusers";
        String userName = "root";
        String password = "Root@#7382";

        String insertSql = "insert into appusers.users values"+"(0,'DeleteUser','7654543210','pass789');";

        try{
            //Establish the Connection with the database
            Connection con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connnected to appusers-db Successfully");
            Statement stm1 = con.createStatement();
            //executeUpdate(String sql):executes DML statements and return int
            int rowsAffected = stm1.executeUpdate(insertSql);
            System.out.println(rowsAffected+"row(s) added");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to connect to appusers-db");


        }
        System.out.println("Program ends...");
    }
}
