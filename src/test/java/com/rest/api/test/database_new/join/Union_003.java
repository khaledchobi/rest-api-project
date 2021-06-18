package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Union_003 {

    public static void main(String args[]){ // UNION With WHERE // SQL statement returns the German cities (only distinct values) from both the "Customers" and the "Suppliers" table
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT City, Country FROM Customers\n" +
                    "    WHERE Country='Germany'\n" +
                    "    UNION\n" +
                    "        SELECT City, Country FROM Offices\n" +
                    "        WHERE Country='Germany'\n" +
                    "        ORDER BY City");

            int count = 0;
            while(rs.next()){

                String city = rs.getString("city");
                String country = rs.getString("country");

                count++;

                System.out.println(count + " " + city + " " + country);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

    /*SELECT City, Country FROM Customers
    WHERE Country='Germany'
    UNION
        SELECT City, Country FROM Offices
        WHERE Country='Germany'
        ORDER BY City;*/