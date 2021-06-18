package com.rest.api.test.database_new.join;

import java.sql.*;

public class InnerJoin_ThreeTables_001 {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Orders.orderNumber, Customers.customerName, OrderDetails.priceEach\n" +
                    "        FROM ((Orders\n" +
                    "        INNER JOIN Customers ON Orders.customerNumber = Customers.customerNumber)\n" +
                    "        INNER JOIN OrderDetails ON Orders.orderNumber = OrderDetails.orderNumber)");

            int count = 0;
            while(rs.next()){
                Integer orderNumber = rs.getInt("orderNumber");
                String customerName = rs.getString("customerName");
                Double priceEach = rs.getDouble("priceEach");
                count++;

                System.out.println(count + " " + orderNumber + " " + customerName + " " + priceEach);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}



    }
}

    /*SELECT Orders.orderNumber, Customers.customerName, OrderDetails.priceEach
        FROM ((Orders
        INNER JOIN Customers ON Orders.customerNumber = Customers.customerNumber)
        INNER JOIN OrderDetails ON Orders.orderNumber = OrderDetails.orderNumber);*/