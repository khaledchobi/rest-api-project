package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Union_001 {

    public static void main(String args[]){ // Union // SQL statement returns the cities (only distinct values) from both the "Customers" and the "Suppliers" table
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT City FROM Customers\n" +
                    "    UNION\n" +
                    "    SELECT City FROM Offices\n" +
                    "    ORDER BY City");

            int count = 0;
            while(rs.next()){

                String city = rs.getString("city");

                count++;

                System.out.println(count + " " + city);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }

}

    /*SELECT City FROM Customers
    UNION
    SELECT City FROM Offices
    ORDER BY City;*/
