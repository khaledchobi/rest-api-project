package com.rest.api.test.databaseLib;

import java.sql.*;

public class DataBaseUtil {
    public static void main(String[] args) throws SQLException {

        // create the connection with database
        String myDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
        String myUrl = "jdbc:sqlserver://localhost:1433";

        Connection con;
        Statement stmt;
        ResultSet rs;

        try {
            con = DriverManager.getConnection(myUrl, "sa", "myPassword@12345");
            stmt = con.createStatement();

            String insertQuery = "Insert into Persons(PersonID, LastName, FirstName, Address, City) Value(10, 'DSouza', 'Peter', 'Summers Ave', 'NY')";
            stmt.executeQuery(insertQuery);

            String query = "select * from Persons";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                String FirstName = rs.getString("FirstName");
                System.out.println(rs.getRow());
                System.out.println(FirstName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }













}
