package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelfJoin_001 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT A.customerName AS customerName1, B.customerName AS customerName2, A.City\n" +
                    "        FROM Customers A, Customers B\n" +
                    "        WHERE A.customerNumber <> B.customerNumber\n" +
                    "        AND A.city = B.city\n" +
                    "        ORDER BY A.city");

            int count = 0;
            while(rs.next()){


                String customerName1 = rs.getString("customerName1");
                String customerName2 = rs.getString("customerName2");
                String city = rs.getString("city");

                count++;

                System.out.println(count + " " + customerName1 + " " + customerName2 + " " + city);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}

    /*SELECT A.customerName AS customerName1, B.customerName AS customerName2, A.city
        FROM Customers A, Customers B
        WHERE A.customerNumber <> B.customerNumber
        AND A.city = B.city
        ORDER BY A.city;*/
