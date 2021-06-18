package com.rest.api.test.database_new.join;

import java.sql.*;

public class InnerJoin_ThreeTables_002 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT OrderDetails.orderNumber, Orders.status, Orders.shippedDate, Products.buyPrice\n" +
                    "        FROM ((OrderDetails\n" +
                    "        INNER JOIN Orders ON OrderDetails.orderNumber = Orders.orderNumber)\n" +
                    "        INNER JOIN Products ON OrderDetails.productCode = Products.productCode)");

            int count = 0;
            while(rs.next()){
                Integer orderNumber = rs.getInt("orderNumber");
                String status = rs.getString("status");
                Date shippedDate = rs.getDate("shippedDate");
                Double buyPrice = rs.getDouble("buyPrice");
                count++;

                System.out.println(count + " " + orderNumber + " " + status + " " + shippedDate + " " + buyPrice);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }

}


/*SELECT OrderDetails.orderNumber, Orders.status, Orders.shippedDate, Products.buyPrice
        FROM ((OrderDetails
        INNER JOIN Orders ON OrderDetails.orderNumber = Orders.orderNumber)
        INNER JOIN Products ON OrderDetails.productCode = Products.productCode);*/