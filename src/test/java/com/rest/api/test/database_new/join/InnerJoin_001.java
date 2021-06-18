package com.rest.api.test.database_new.join;

import java.sql.*;

public class InnerJoin_001 {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Orders.orderNumber, Customers.customerName, Orders.orderDate\n" +
                    "        FROM Orders\n" +
                    "        INNER JOIN Customers\n" +
                    "        ON Orders.customerNumber=Customers.customerNumber");

            int count = 0;
            while(rs.next()){
                Integer orderNumber = rs.getInt("orderNumber");
                String customerName = rs.getString("customerName");
                Date orderDate = rs.getDate("orderDate");
                count++;

                System.out.println(count + " " + orderNumber + " " + customerName + " " + orderDate);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

    /*SELECT Orders.orderNumber, Customers.customerName, Orders.orderDate
        FROM Orders
        INNER JOIN Customers
        ON Orders.customerNumber=Customers.customerNumber;*/

    /*SELECT column_name(s)
    FROM table1
    INNER JOIN table2
        ON table1.column_name = table2.column_name;*/
