package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Union_005 {

    public static void main(String args[]){ // UNION // SQL statement lists all customers and suppliers
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT 'Customer' AS Type, addressLine1, City, Country\n" +
                    "        FROM Customers\n" +
                    "        UNION\n" +
                    "        SELECT 'Supplier', addressLine1, City, Country\n" +
                    "        FROM Offices");

            int count = 0;
            while(rs.next()){

                String type = rs.getString("Type");
                String addressLine1 = rs.getString("addressLine1");
                String city = rs.getString("city");
                String country = rs.getString("country");

                count++;

                System.out.println(count + " " + type + " " + addressLine1 + " " + city + " " + country);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

/*SELECT 'Customer' AS Type, addressLine1, City, Country
        FROM Customers
        UNION
        SELECT 'Supplier', addressLine1, City, Country
        FROM Offices*/
