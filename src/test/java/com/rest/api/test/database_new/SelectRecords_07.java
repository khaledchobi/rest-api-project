package com.rest.api.test.database_new;

import java.sql.*;

public class SelectRecords_07 {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Customers";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Nishat1631981";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            /*String sql = "SELECT customerNumber, customerName, contactLastName, contactFirstName, salesRepEmployeeNumber FROM Customers";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int customerNumber  = rs.getInt("customerNumber");
                int salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
                String customerName = rs.getString("customerName");
                String contactLastName = rs.getString("contactLastName");
                String contactFirstName = rs.getString("contactFirstName");

                //Display values
                System.out.print("Customer Number: " + customerNumber);
                System.out.print(", Customer Name: " + customerName);
                System.out.print(", SalesRepEmployeeNumber: " + salesRepEmployeeNumber);
                System.out.print(", Contact Last Name: " + contactLastName);
                System.out.println(", Contact First Name: " + contactFirstName);
            }*/

            String sql = "SELECT customerNumber, customerName, contactLastName, contactFirstName, salesRepEmployeeNumber FROM Customers";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int customerNumber  = rs.getInt("customerNumber");
                int salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
                String customerName = rs.getString("customerName");
                String contactLastName = rs.getString("contactLastName");
                String contactFirstName = rs.getString("contactFirstName");

                //Display values
                System.out.print("Customer Number: " + customerNumber);
                System.out.print(", Customer Name: " + customerName);
                System.out.print(", SalesRepEmployeeNumber: " + salesRepEmployeeNumber);
                System.out.print(", Contact Last Name: " + contactLastName);
                System.out.println(", Contact First Name: " + contactFirstName);
            }

            System.out.println(sql);


            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}