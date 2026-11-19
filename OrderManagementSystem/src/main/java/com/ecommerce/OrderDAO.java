
package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {

    
    public void insertOrder(int orderId, String customerName,
                            String productName, int quantity,
                            double unitPrice, String status) {

        String sql = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            ps.setString(2, customerName);
            ps.setString(3, productName);
            ps.setInt(4, quantity);
            ps.setDouble(5, unitPrice);
            ps.setString(6, status);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Order inserted successfully!");
            }

        } catch (SQLException e) {

         
            if ("23000".equals(e.getSQLState())) {
                System.out.println("Duplicate Order ID! Order already exists.");
            } else {
                System.out.println("Error inserting order: " + e.getMessage());
            }
        }
    }

    public void filterOrdersByStatus(String status) {

    String sql = "SELECT * FROM Orders " +
                 "WHERE status = ? AND quantity > 2 " +
                 "ORDER BY unit_price DESC";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

       
        ps.setString(1, status);

      
        ResultSet rs = ps.executeQuery();

        boolean found = false;

        System.out.println("\n--- Filtered Orders ---");

        while (rs.next()) {

            found = true;

            System.out.println("Order ID: " + rs.getInt("order_id"));
            System.out.println("Customer: " + rs.getString("customer_name"));
            System.out.println("Product: " + rs.getString("product_name"));
            System.out.println("Quantity: " + rs.getInt("quantity"));
            System.out.println("Unit Price: " + rs.getDouble("unit_price"));
            System.out.println("Status: " + rs.getString("status"));

            System.out.println("-----------------------");
        }

        if (!found) {
            System.out.println("No matching orders found.");
        }

    } catch (SQLException e) {
        System.out.println("Error filtering orders: " + e.getMessage());
    }
}
    public void updateQuantity(int orderId, int additionalQuantity) {

    String sql = "UPDATE Orders SET quantity = quantity + ? "
               + "WHERE order_id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, additionalQuantity);
        ps.setInt(2, orderId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Order quantity updated successfully!");
        } else {
            System.out.println("Order ID not found!");
        }

    } catch (SQLException e) {
        System.out.println("Error updating quantity: " + e.getMessage());
    }
}
    public void updateStatus(int orderId, String newStatus) {

    if (!newStatus.equals("Pending") &&
        !newStatus.equals("Shipped") &&
        !newStatus.equals("Delivered")) {

        System.out.println("Invalid status!");
        return;
    }

    String checkSql = "SELECT * FROM Orders WHERE order_id = ?";
    String updateSql = "UPDATE Orders SET status = ? WHERE order_id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement checkPs = con.prepareStatement(checkSql)) {

        checkPs.setInt(1, orderId);

        ResultSet rs = checkPs.executeQuery();

        if (rs.next()) {

            try (PreparedStatement updatePs = con.prepareStatement(updateSql)) {

                updatePs.setString(1, newStatus);
                updatePs.setInt(2, orderId);

                updatePs.executeUpdate();

                System.out.println("Order status updated successfully!");
                System.out.println("Order ID: " + orderId);
                System.out.println("Customer: " + rs.getString("customer_name"));
                System.out.println("Product: " + rs.getString("product_name"));
                System.out.println("New Status: " + newStatus);
            }

        } else {
            System.out.println("Order ID not found!");
        }

    } catch (SQLException e) {
        System.out.println("Error updating status: " + e.getMessage());
    }
}
public void displayTotalOrderValue() {

    String sql = "SELECT SUM(quantity * unit_price) AS total FROM Orders";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            System.out.println("Total Order Value: " + rs.getDouble("total"));
        }

    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
public void deleteCancelledOrder(int orderId) {

    String sql = "DELETE FROM Orders WHERE order_id = ? AND status = 'Cancelled'";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, orderId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Cancelled order deleted successfully!");
        } else {
            System.out.println("Order not found or order is not Cancelled. Cannot delete.");
        }

    } catch (SQLException e) {
        System.out.println("Error deleting order: " + e.getMessage());
    }
}
}
