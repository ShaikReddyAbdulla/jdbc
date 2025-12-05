package com.jspiders.jdbc.demo;

import java.sql.*;
import java.util.Scanner;

public class Demo {
    private static final Scanner sc1 = new Scanner(System.in);
    private static final String dbUrl ="jdbc:mysql://localhost:3306/appusers";
    private static final String dbUser = "root";
    private static final String dbPassword = "Root@#7382";
    public static void addUser() {

        System.out.print("Enter username: ");
        String name = sc1.next();
        System.out.print("Enter user Mobile number : ");
        String mobile = sc1.next();
        System.out.print("Enter user Password : ");
        String password = sc1.next();

        String insertSql = "insert into appUsers.users values(0,"+"'"+name+"'"+","+"'"+mobile+"'"+","+"'"+password+"'"+");";
        System.out.println(insertSql);
    }
    public static void addUser2() {
        System.out.println("You are going to add an User");
        System.out.print("Enter username: ");
        String name = sc1.next();
        System.out.print("Enter user Mobile number : ");
        String mobile = sc1.next();
        System.out.print("Enter user Password : ");
        String password = sc1.next();

        String insertSql = "insert into appusers.users values(0,?,?,?);";

        try {
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1,name);//ps.setString(ParameterIndex,Value);
            ps.setString(2,mobile);
            ps.setString(3,password);

            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected+" row(s) inserted");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void updateUser() {
        System.out.println("You are going to update an User");
        System.out.println("Enter current mobile number : ");
        String currMobile = sc1.next();
        System.out.println("Enter new mobile number : ");
        String newMobile = sc1.next();
        String updateSql = "update appusers.users set mobile=? where mobile=?";
        try {
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setString(1,currMobile);
            ps.setString(2,newMobile);
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected+" row(s) updated");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void deleteUser() {
        System.out.println("You are going to delete an User");
        System.out.println("Enter userId to delete : ");
        int userId = sc1.nextInt();
        String deleteSql = "delete from appusers.users where userId=?";

        try
        {
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1,userId);
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected+" row(s) deleted");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to connect to appusers-db");
        }
    }
    public static void getUser(){
        String selectSql = "SELECT * from appusers.users;";
        try
        {
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(selectSql);

            rs.next();//Moves Cursor to 1st line
            int userId = rs.getInt("userId");
            String name = rs.getString("name");
            String mobile = rs.getString("mobile");
            String password = rs.getString("password");
            System.out.println(userId);

            rs.next();//Moves Cursor to 2nd line

            userId = rs.getInt("userId");
            name = rs.getString("name");
            mobile = rs.getString("mobile");
            password = rs.getString("password");
            System.out.println(userId);

            while(rs.next() == true){
                userId = rs.getInt("userId");
                name = rs.getString("name");
                mobile = rs.getString("mobile");
                password = rs.getString("password");
                System.out.println(userId+" "+name+" "+mobile+" "+password);

            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void getUserByMobile(){
        System.out.println("You are going to get an User");
        System.out.print("Enter User mobile number : ");
        String mobile = sc1.next();
        String selectSql = "SELECT * from appusers.users where mobile=?";

        try
        {
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setString(1,mobile);
            ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    int userId = rs.getInt("userId");
                    String name = rs.getString("name");
                    String password = rs.getString("password");
                    System.out.println(userId + " " + name + " " + " " + mobile + " " + password);
                }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Program starts...");
          addUser2();
//        updateUser();
//        deleteUser();
//        getUser();
//        getUserByMobile();
        System.out.println("Program ends...");
    }
}
