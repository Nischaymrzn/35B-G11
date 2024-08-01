package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.EventModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class EventOperations{
    DatabaseConnection db = new DatabaseConnection();

    public void addEvent(EventModel event){
        Connection conn = db.openConnection();
        String sql = "INSERT INTO event (eventId, eventName, eventDescription, eventDate, eventTime, eventLocation, eventCategory) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, event.getEventId());
            pstmt.setString(2, event.getEventName());
            pstmt.setString(3, event.getEventDescription());
            pstmt.setString(4, event.getEventDate());
            pstmt.setString(5, event.getEventTime());
            pstmt.setString(6, event.getEventLocation());
            pstmt.setString(7, event.getEventCategory());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }


}