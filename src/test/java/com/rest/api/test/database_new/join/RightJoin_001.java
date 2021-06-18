package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RightJoin_001 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Orders.orderNumber, Customers.contactLastName, Customers.contactFirstName\n" +
                    "        FROM Orders\n" +
                    "        RIGHT JOIN Customers\n" +
                    "        ON Orders.customerNumber = Customers.customerNumber\n" +
                    "        ORDER BY Orders.orderNumber");

            int count = 0;
            while(rs.next()){

                Integer orderNumber = rs.getInt("orderNumber");
                String contactLastName = rs.getString("contactLastName");
                String contactFirstName = rs.getString("contactFirstName");

                count++;

                System.out.println(count + " " + orderNumber + " " + contactLastName + " " + contactFirstName);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}

    /*SELECT Orders.orderNumber, Customers.contactLastName, Customers.contactFirstName
        FROM Orders
        RIGHT JOIN Customers
        ON Orders.customerNumber = Customers.customerNumber
        ORDER BY Orders.orderNumber;*/

