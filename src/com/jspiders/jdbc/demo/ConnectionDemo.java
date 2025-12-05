package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {
        System.out.println("Program starts...");
        //protocol//hosts:port/database
        String url = "jdbc:mysql://localhost:3306/testDB";
        String userName = "root";
        String password = "Root@#7382";

        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            System.out.println("DataBase Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to connect to the DataBase");
        }
        System.out.println("Program ends...");
    }
}
