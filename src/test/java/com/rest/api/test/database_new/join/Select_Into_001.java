package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_Into_001 { // Not Completed


    public static void main(String args[]){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * INTO CustomersGermany\n" +
                    "        FROM Customers\n" +
                    "        WHERE Country = 'Germany'");

            int count = 0;
            while(rs.next()){

                String country = rs.getString("country");


                count++;

                System.out.println(count + " " + country);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}


/*SELECT * INTO CustomersGermany
        FROM Customers
        WHERE Country = 'Germany';*/