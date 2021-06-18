package com.rest.api.test.database_new.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Any_All_003 {

    // ALL Example
    // The ALL operator returns TRUE if all of the subquery values meet the condition.
    // The following SQL statement returns TRUE and lists the product names if ALL the
    // records in the OrderDetails table has quantity = 10 (so, this example will return
    // FALSE, because not ALL records in the OrderDetails table has quantity = 10)


    public static void main(String args[]){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers","root","Nishat1631981");
            //here Customers is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT customerNumber\n" +
                    "    FROM Orders\n" +
                    "    WHERE orderNumber = ALL (SELECT orderNumber FROM OrderDetails WHERE quantityOrdered = 10)");

            int count = 0;
            while(rs.next()){

                String customerNumber = rs.getString("customerNumber");


                count++;

                System.out.println(count + " " + customerNumber);
                System.out.println();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}

/*SELECT customerNumber
    FROM Orders
    WHERE orderNumber = ALL (SELECT orderNumber FROM OrderDetails WHERE quantityOrdered = 10);*/