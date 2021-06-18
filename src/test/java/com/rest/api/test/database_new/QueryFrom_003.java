package com.rest.api.test.database_new;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryFrom_003 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            while(rs.next()){
                String customerName = rs.getString("customerName");
                System.out.println(customerName);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}



    }
}
