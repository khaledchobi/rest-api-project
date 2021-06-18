package com.rest.api.test.database_new;

import java.sql.*;

public class QueryFrom {

    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/Customers"; // Mysql@127.0.0.1:3306
        String username = "root";
        String password = "Nishat1631981";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Customers";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);



            int count = 0;
            while (result.next()){
                String customerNumber = result.getString("customerNumber");
                String customerName = result.getString("customerName");
                count++;

                System.out.println(count + " Customer ID: " + customerNumber + " Customer Name: " + customerName);
            }
            //connection.close();

        }catch(SQLException e){
            System.out.println("Oops, error!");
            e.printStackTrace();

        }
    }
}
