package com.rest.api.test.database_new.practiceOnSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query_006 {

    public static void main(String args[]){ // Highest with  checkNumber And Amount
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT checkNumber, amount FROM Customers.payments\n" +
                    "WHERE amount = (SELECT MAX(amount) FROM Customers.payments);");

            while(rs.next())
                System.out.println(rs.getString(1) + " " + rs.getDouble(2));
            System.out.println();
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}
