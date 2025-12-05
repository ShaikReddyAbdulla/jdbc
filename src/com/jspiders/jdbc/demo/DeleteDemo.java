package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteDemo {
    public static void main(String[] args) {
        System.out.println("Program starts...");
        String url = "jdbc:mysql://localhost:3306/appusers";
        String userName = "root";
        String password = "Root@#7382";

        String deleteSql = "delete from appusers where userid = 1";
        try{
            Connection con =  DriverManager.getConnection(url, userName, password);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        System.out.println("Program starts...");
    }
}
