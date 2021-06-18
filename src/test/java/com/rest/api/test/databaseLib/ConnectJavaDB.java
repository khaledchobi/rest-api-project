package com.rest.api.test.databaseLib;

import java.sql.*;

public class ConnectJavaDB {
    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Customers"; // Mysql@127.0.0.1:3306
        String username = "root";
        String password = "Nishat1631981";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM customers";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;
            while (result.next()){
                String firstName = result.getString("contactFirstName");
                String lastName = result.getString("contactLastName");
                count++;

                System.out.println("Customer " + count + ": " + firstName + " " + lastName);
            }
            //connection.close();

        }catch(SQLException e){
            System.out.println("Oops, error!");
            e.printStackTrace();

        }
    }
}