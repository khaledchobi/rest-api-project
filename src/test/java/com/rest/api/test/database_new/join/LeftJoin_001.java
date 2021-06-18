package com.rest.api.test.database_new.join;

import java.sql.*;

public class LeftJoin_001 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Customers.customerName, Orders.orderNumber\n" +
                    "        FROM Customers\n" +
                    "        LEFT JOIN Orders\n" +
                    "        ON Customers.customerNumber=Orders.customerNumber\n" +
                    "        ORDER BY Customers.customerName");

            int count = 0;
            while(rs.next()){
                String customerName = rs.getString("customerName");
                Integer orderNumber = rs.getInt("orderNumber");

                count++;

                System.out.println(count + " " + customerName + " " + orderNumber);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}

    /*SELECT Customers.customerName, Orders.orderNumber
        FROM Customers
        LEFT JOIN Orders
        ON Customers.customerNumber=Orders.customerNumber
        ORDER BY Customers.customerName;*/