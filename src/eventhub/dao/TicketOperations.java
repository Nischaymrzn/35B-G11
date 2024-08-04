package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.TicketModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketOperations {
    DatabaseConnection db = new DatabaseConnection();

    public void addTicket(TicketModel ticket) {
        Connection conn = db.openConnection();
        String sql = "INSERT INTO ticket (ticketId,userId,eventId,organizerId,ticketAmount) VALUES (?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ticket.getTicketId());
            pstmt.setInt(2, ticket.getUserId());
            pstmt.setInt(3, ticket.getEventId());
            pstmt.setInt(4, ticket.getOrganizerId());
            pstmt.setInt(5, ticket.getTicketAmount());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TicketOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public void deleteTicket(int ticketId) {
        Connection conn = db.openConnection();
        String sql = "DELETE FROM ticket WHERE ticketId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ticketId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TicketOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public ArrayList<TicketModel> getAllTicket(int ticketId) {
        Connection conn = db.openConnection();
        ArrayList<TicketModel> data = new ArrayList<>();
        String sql = "SELECT * FROM ticket";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                TicketModel ticket = new TicketModel(
                        result.getInt("ticketId"),
                        result.getInt("userId"),
                        result.getInt("organizerId"),
                        result.getInt("eventId"),
                        result.getInt("ticketAmount")
                );
                data.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return data;
    }
}
