package com.rest.api.test.database_new.practiceOnSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query_001 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT MAX(customerNumber) as customerNumber FROM Customers");
            while(rs.next())
                System.out.println(rs.getInt(1));
            System.out.println();
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}
