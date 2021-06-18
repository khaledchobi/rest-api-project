package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Having_003 {

    public static void main(String args[]){ // SQL statement lists the customers that have registered more than 10 orders
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Customers.contactLastName, COUNT(Orders.orderNumber) AS NumberOfOrders\n" +
                    "        FROM (Orders\n" +
                    "        INNER JOIN Customers ON Orders.customerNumber = Customers.customerNumber)\n" +
                    "        GROUP BY contactLastName\n" +
                    "        HAVING COUNT(Orders.orderNumber) > 10");

            int count = 0;
            while(rs.next()){

                String contactLastName = rs.getString("contactLastName");

                String numberOfOrders = rs.getString("NumberOfOrders");

                count++;

                System.out.println(count + " " + contactLastName + " " + numberOfOrders);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

    /*SELECT Customers.contactLastName, COUNT(Orders.orderNumber) AS NumberOfOrders
        FROM (Orders
        INNER JOIN Customers ON Orders.customerNumber = Customers.customerNumber)
        GROUP BY contactLastName
        HAVING COUNT(Orders.orderNumber) > 10;*/