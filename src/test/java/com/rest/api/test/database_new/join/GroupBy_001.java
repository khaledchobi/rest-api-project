package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GroupBy_001 {

    public static void main(String args[]){ // SQL statement lists the number of customers in each country
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(customerNumber), Country\n" +
                    "    FROM Customers\n" +
                    "    GROUP BY Country");

            int count = 0;
            while(rs.next()){

                String countListsNumbers = rs.getString("COUNT(customerNumber)");

                String country = rs.getString("country");

                count++;

                System.out.println(count + " " + countListsNumbers + " " + country);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

    /*SELECT COUNT(customerNumber), Country
    FROM Customers
    GROUP BY Country;*/