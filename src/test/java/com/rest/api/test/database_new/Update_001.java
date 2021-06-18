package com.rest.api.test.database_new;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_001 { // Not working yet

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Customers","root","Nishat1631981"); // :3306
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();

            // Step 3 & 4: Execute a SQL UPDATE via executeUpdate()
            // which returns an int indicating the number of rows affected.
            // Increase the creditLimit by 1%
            String strUpdate = "UPDATE Customers SET creditLimit=creditLimit + (creditLimit * 1.0/100.0)";
            System.out.println("The SQL statement is: " + strUpdate + "\n");  // Echo for debugging
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected.\n");

            // Step 3 & 4: Issue a SELECT (via executeQuery()) to check the UPDATE.
            String strSelect = "SELECT * FROM Customers";
            System.out.println("The SQL statement is: " + strSelect + "\n");  // Echo for debugging

            ResultSet rs = stmt.executeQuery(strSelect);
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(13));
            System.out.println();
            con.close();
        }catch(Exception e){ System.out.println(e);}



    }

}

    //UPDATE Customers SET creditLimit=creditLimit + (creditLimit * 1.0/100.0);