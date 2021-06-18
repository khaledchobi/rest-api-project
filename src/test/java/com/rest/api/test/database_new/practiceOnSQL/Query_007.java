package com.rest.api.test.database_new.practiceOnSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query_007 {

    public static void main(String args[]){ // // select 2nd highest amount in payments table
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT MAX(AMOUNT) FROM Customers.payments\n" +
                    "WHERE AMOUNT Not In (SELECT MAX(AMOUNT) FROM Customers.payments);");

            while(rs.next())
                System.out.println(rs.getDouble(1));
            System.out.println();
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}
