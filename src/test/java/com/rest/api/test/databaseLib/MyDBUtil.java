package com.rest.api.test.databaseLib;

import java.sql.*;

public class MyDBUtil {
    public static void main(String[] args) throws SQLException {

        try {
            // create the connection with database
            String myDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
            String myUrl = "jdbc:sqlserver://localhost:3306";
            // Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "root", "Nishathasan1631981");;

            // the mysql insert statement
            // String query = " insert into users (first_name, last_name, date_created, is_admin, num_points) values (?, ?, ?, ?, ?)";
            Statement stmt = conn.createStatement();
            ResultSet rs;

            stmt.executeUpdate("INSERT INTO Persons VALUES (2, 'S', 'Tom', 'Springfield', 'NY')");


            /*String insertQuery = "Insert into Persons(PersonID, LastName, FirstName, Address, City) Value(10, 'DSouza', 'Peter', 'Summers Ave', 'NY')";
            stmt.executeQuery(insertQuery);*/

            String query = "select * from Persons";
            //String query = "select * from Persons where PersonID = 2";


            rs = stmt.executeQuery(query);
            while (rs.next()){
                String FirstName = rs.getString("FirstName");
                System.out.println(rs.getRow());
                System.out.println(FirstName);
            }
            conn.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }





    }
}
