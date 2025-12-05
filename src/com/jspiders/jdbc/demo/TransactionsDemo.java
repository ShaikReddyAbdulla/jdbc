package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionsDemo {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/appUsers";
    private static final String userName = "root";
    private static final String password = "Root@#7382";
    private static Connection con = null;
    public static void main(String[] args) {
        System.out.println("Program Starts...");
        try
        {
            con = DriverManager.getConnection(dbUrl,userName,password);
            con.setAutoCommit(false);
            //SQL
            System.out.println("Adding User..");
            String insertSql = "insert into appUsers.users values (0,'Transa','987654324','pass789');";
            Statement sm1 = con.createStatement();
            sm1.executeUpdate(insertSql);
            System.out.println("Adding user Successful");

            System.out.println("Update User");
            String updateSql = "update appusers.users set mobile ='2000000000' where mobile ='987654324';";
            Statement sm2 = con.createStatement();
            int rowsAffected = sm2.executeUpdate(updateSql);
            if(rowsAffected == 0 ){
                throw new SQLException("User with mobile number not found");
            }
            System.out.println("Updating user successful for "+rowsAffected+" user(s)");
            con.commit();//Save all
        }
        catch(SQLException e)
        {

           e.printStackTrace();
        }
        System.out.println("Program ends...");

    }
}
