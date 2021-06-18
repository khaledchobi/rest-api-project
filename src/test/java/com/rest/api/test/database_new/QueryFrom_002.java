package com.rest.api.test.database_new;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryFrom_002 { // SELECT customerName FROM Customers WHERE city = 'NYC'

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT customerName FROM Customers WHERE city = 'NYC'");
            while(rs.next()){
                String customerName = rs.getString("customerName");
                System.out.println(customerName);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}



    }
}
