package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Having_001 {

    public static void main(String args[]){ // SQL statement lists the number of customers in each country. Only include countries with more than 5 customers
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(customerNumber), Country\n" +
                    "    FROM Customers\n" +
                    "    GROUP BY Country\n" +
                    "        HAVING COUNT(customerNumber) > 5");

            int count = 0;
            while(rs.next()){

                String customerNumberCount = rs.getString("COUNT(customerNumber)");

                String country = rs.getString("country");

                count++;

                System.out.println(count + " " + customerNumberCount + " " + country);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

    /*SELECT COUNT(customerNumber), Country
    FROM Customers
    GROUP BY Country
        HAVING COUNT(customerNumber) > 5;*/
