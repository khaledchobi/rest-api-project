package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exists_002 {

    public static void main(String args[]){ // SQL statement returns TRUE and lists the suppliers with a product price equal to 54
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT customerNumber\n" +
                    "    FROM Orders\n" +
                    "    WHERE EXISTS (SELECT productCode FROM orderdetails WHERE orderdetails.orderNumber = Orders.orderNumber AND priceEach = 54)");

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
    WHERE EXISTS (SELECT productCode FROM orderdetails WHERE orderdetails.orderNumber = Orders.orderNumber AND priceEach = 54);*/