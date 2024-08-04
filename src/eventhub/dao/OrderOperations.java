package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.OrderModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderOperations {
    DatabaseConnection db = new DatabaseConnection();
    public void addOrder(OrderModel order) {
       Connection conn = db.openConnection();
         String sql = "INSERT INTO order (orderId,ticketId,fullname,country, city, address, zipcode) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, order.getOrderId());
                pstmt.setInt(2, order.getTicketId());
                pstmt.setString(3, order.getFullName());
                pstmt.setString(4, order.getCountry());
                pstmt.setString(5, order.getCity());
                pstmt.setString(6, order.getAddress());
                pstmt.setString(7, order.getZipCode());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OrderOperations.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                db.closeConnection(conn);
            }

    }

    public void deleteOrder(int orderId) {
        Connection conn = db.openConnection();
        String sql = "DELETE FROM order WHERE orderId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public ArrayList<OrderModel> getAllOrder(int orderId) {
        Connection conn = db.openConnection();
        ArrayList<OrderModel> data = new ArrayList<>();
        String sql = "SELECT * FROM order";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                OrderModel order = new OrderModel(
                        result.getInt("orderId"),
                        result.getInt("ticketId"),
                        result.getString("fullname"),
                        result.getString("country"),
                        result.getString("city"),
                        result.getString("address"),
                        result.getString("zipcode")
                );
                data.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
