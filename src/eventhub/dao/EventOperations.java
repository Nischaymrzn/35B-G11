package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.EventModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventOperations {
    DatabaseConnection db = new DatabaseConnection();

    public void addEvent(EventModel event) {
        Connection conn = db.openConnection();
        String sql = "INSERT INTO event (organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, event.getOrganizerId());
            pstmt.setString(2, event.getEventName());
            pstmt.setString(3, event.getEventType());
            pstmt.setString(4, event.getEventDate());
            pstmt.setString(5, event.getEventTime());
            pstmt.setString(6, event.getEventDescription());
            pstmt.setInt(7, event.getEventRate());
            pstmt.setBytes(8, event.getImage());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }
    public void deleteEvent(int eventId) {
        Connection conn = db.openConnection();
        String sql = "DELETE FROM event WHERE eventId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }
     public ArrayList<EventModel> getAllEvents() {
        ArrayList<EventModel> events = new ArrayList<>();
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM event";
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                int eventId = resultSet.getInt("eventId");
                int organizerId = resultSet.getInt("organizerId");
                String eventName = resultSet.getString("eventName");
                String eventType = resultSet.getString("eventType");
                String eventDate = resultSet.getString("eventDate");
                String eventTime = resultSet.getString("eventTime");
                String eventDescription = resultSet.getString("eventDescription");
                int eventRate = resultSet.getInt("eventRate");
                byte[] image = resultSet.getBytes("image");

                EventModel event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image);
                event.setEventId(eventId);
                events.add(event);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return events;
    }
     
     
         public ArrayList<EventModel> getAllConcerts() {
        return getEventsByType("concert");
    }

    public ArrayList<EventModel> getAllMovies() {
        return getEventsByType("movie");
    }

    private ArrayList<EventModel> getEventsByType(String eventType) {
        ArrayList<EventModel> events = new ArrayList<>();
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM event WHERE eventType = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, eventType);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    int eventId = resultSet.getInt("eventId");
                    int organizerId = resultSet.getInt("organizerId");
                    String eventName = resultSet.getString("eventName");
                    String eventDate = resultSet.getString("eventDate");
                    String eventTime = resultSet.getString("eventTime");
                    String eventDescription = resultSet.getString("eventDescription");
                    int eventRate = resultSet.getInt("eventRate");
                    byte[] image = resultSet.getBytes("image");

                    EventModel event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image);
                    event.setEventId(eventId);
                    events.add(event);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return events;
    }
  public EventModel getEventById(int eventId) {
    EventModel event = null;
    Connection conn = db.openConnection();
    String sql = "SELECT * FROM event WHERE eventId = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, eventId);
        try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                int organizerId = resultSet.getInt("organizerId");
                String eventName = resultSet.getString("eventName");
                String eventType = resultSet.getString("eventType");
                String eventDate = resultSet.getString("eventDate");
                String eventTime = resultSet.getString("eventTime");
                String eventDescription = resultSet.getString("eventDescription");
                int eventRate = resultSet.getInt("eventRate");
                byte[] image = resultSet.getBytes("image");

                event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image);
                event.setEventId(eventId);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(EventOperations.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        db.closeConnection(conn);
    }
    return event;
}
  
 public ArrayList<EventModel> getAllOrganizerEvents(int organizerId) {
        ArrayList<EventModel> events = new ArrayList<>();
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM event WHERE organizerId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, organizerId);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    int eventId = resultSet.getInt("eventId");
                    String eventName = resultSet.getString("eventName");
                    String eventType = resultSet.getString("eventType");
                    String eventDate = resultSet.getString("eventDate");
                    String eventTime = resultSet.getString("eventTime");
                    String eventDescription = resultSet.getString("eventDescription");
                    int eventRate = resultSet.getInt("eventRate");
                    byte[] image = resultSet.getBytes("image");

                    EventModel event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image);
                    event.setEventId(eventId);
                    events.add(event);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }

        return events;
    }

     
       
}

