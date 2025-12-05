package com.jspiders.jdbc.demo;

import java.sql.*;

public class SQLInjectionDemo {
    private static final String dbUrl ="jdbc:mysql://localhost:3306/appusers";
    private static final String dbUser = "root";
    private static final String dbPassword = "Root@#7382";

    public static void loginV2(String mobile,String pass){
        String selectSql = "select * from users where mobile=? and password=?;";

        try
        {
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            PreparedStatement psm1 = con.prepareStatement(selectSql);
            psm1.setString(1,mobile);
            psm1.setString(2,pass);
            System.out.println("Query : "+psm1);
            ResultSet rs = psm1.executeQuery();

            if(rs.next()){
                System.out.println("Login Success");
            }else{
                System.out.println("Login Failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void login(String mobile,String password){
        String selectSql = "select * from users"+ " where mobile=' " +mobile+ " ' AND password=' " +password +" '";
      try
      {
          Connection con= DriverManager.getConnection(dbUrl,dbUser,dbPassword);
          Statement stm1=con.createStatement();
          System.out.println("Query : "+selectSql);

          ResultSet rs = stm1.executeQuery(selectSql);

          if(rs.next()){
              System.out.println("Login Success");
          }else{
              System.out.println("Login Failed");
          }
      }
      catch(SQLException e)
      {

      }
    }
    public static void main(String[] args) {
        System.out.println("Program starts...");
        String mobile = "OR '1'='1'";
        String password = "OR '1'='1' ";
        String mobile1 ="987654324" ;
        String password1 = "pass789";

        login(mobile,password);
        //loginV2(mobile,password);
        //loginV2(mobile1,password1);
        System.out.println("Program ends...");
    }
}
