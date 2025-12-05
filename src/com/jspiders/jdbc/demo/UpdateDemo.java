package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
    public static void main(String[] args) {
        System.out.println("Program starts...");
        String url = "jdbc:mysql://localhost:3306/appusers";
        String userName = "root";
        String password = "Root@#7382";

        String updateSql = "update appusers.users set mobile='7654321098' where userid=1;";

        try
        {
            Connection con = DriverManager.getConnection(url,userName,password);
            System.out.println("Connected to appusers-db Successfully");
            Statement stm1 = con.createStatement();
            //executeUpdate(String sql) : execetes DML statements and return int
            int rowsAffected = stm1.executeUpdate(updateSql);
            System.out.println(rowsAffected+" row(s) updated");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to connect to appusers-db");
        }
        System.out.println("Program ends...");
    }
}
