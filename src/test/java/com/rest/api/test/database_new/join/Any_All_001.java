package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Any_All_001 {

    public static void main(String args[]){ // SQL statement returns TRUE and lists the product names if it finds ANY records in the OrderDetails table that quantity = 10
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT customerNumber\n" +
                    "    FROM Orders\n" +
                    "    WHERE orderNumber = ANY (SELECT orderNumber FROM OrderDetails WHERE quantityOrdered = 10)");

            int count = 0;
            while(rs.next()){

                String customerNumber = rs.getString("customerNumber");


                count++;

                System.out.println(count + " " + customerNumber);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

    /*SELECT customerNumber
    FROM Orders
    WHERE orderNumber = ANY (SELECT orderNumber FROM OrderDetails WHERE quantityOrdered = 10);*/