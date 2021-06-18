package com.rest.api.test.database_new.practiceOnSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query_008 {

    public static void main(String args[]){ // select range of employee based on id
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Customers.customers\n" +
                    "WHERE customerNumber between 200 and 350;");

            while(rs.next())
                System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getString(6));
            System.out.println();
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}
