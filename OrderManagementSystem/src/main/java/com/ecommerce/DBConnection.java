
package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database details
    private static final String URL =
        "jdbc:mysql://localhost:3306/ecommerce_db";

    private static final String USER =
        "root";

    private static final String PASSWORD =
        "It's Private 🔒";

    // Method to establish connection
    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(
                URL, USER, PASSWORD
            );

            System.out.println("Database connected successfully!");

            return con;

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();

            return null;
        }
    }

    // Main method to test connection
    public static void main(String[] args) {

        Connection con = getConnection();

        if (con != null) {
            try {
                con.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
