package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GruopByWithJoin_001 {

    public static void main(String args[]){ // SQL statement lists the number of orders sent by each customer
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Customers.customerName, COUNT(Orders.customerNumber) AS NumberOfOrders FROM Orders\n" +
                    "        LEFT JOIN Customers ON Orders.customerNumber = Customers.customerNumber\n" +
                    "        GROUP BY customerName");

            int count = 0;
            while(rs.next()){

                String customerName = rs.getString("customerName");

                String numberOfOrders = rs.getString("NumberOfOrders");

                count++;

                System.out.println(count + " " + customerName + " " + numberOfOrders);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

    /*SELECT Customers.customerName, COUNT(Orders.customerNumber) AS NumberOfOrders FROM Orders
        LEFT JOIN Customers ON Orders.customerNumber = Customers.customerNumber
        GROUP BY customerName;*/