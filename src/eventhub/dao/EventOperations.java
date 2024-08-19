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
        String sql = "INSERT INTO event (organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image, eventLocation, eventVenue) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, event.getOrganizerId());
            pstmt.setString(2, event.getEventName());
            pstmt.setString(3, event.getEventType());
            pstmt.setString(4, event.getEventDate());
            pstmt.setString(5, event.getEventTime());
            pstmt.setString(6, event.getEventDescription());
            pstmt.setInt(7, event.getEventRate());
            pstmt.setBytes(8, event.getImage());
            pstmt.setString(9, event.getEventLocation()); // Added line
            pstmt.setString(10, event.getEventVenue()); // Added line
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
    
  public void updateEvent(EventModel event) {
    String query = "UPDATE event SET organizerId=?, eventName = ?, eventType = ?, eventDate = ?, eventTime = ?, eventRate = ?, eventDescription = ?, image = ?, eventLocation = ?, eventVenue = ? WHERE eventId = ?";
    
    try (Connection conn = db.openConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, event.getOrganizerId());
        pstmt.setString(2, event.getEventName());
        pstmt.setString(3, event.getEventType());
        pstmt.setString(4, event.getEventDate());
        pstmt.setString(5, event.getEventTime());
        pstmt.setDouble(6, event.getEventRate());
        pstmt.setString(7, event.getEventDescription());
        pstmt.setBytes(8, event.getImage());
        pstmt.setString(9, event.getEventLocation());
        pstmt.setString(10, event.getEventVenue());
        pstmt.setInt(11, event.getEventId());
        System.out.println(event.getEventId());

        // Print the query with the actual values
        System.out.println("Executing update: " + pstmt.toString());

        int rowsAffected = pstmt.executeUpdate();

        // Confirm if the update was successful
        System.out.println("Rows affected: " + rowsAffected);
        
    } catch (SQLException e) {
        e.printStackTrace();
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
                String eventLocation = resultSet.getString("eventLocation"); // Added line
                String eventVenue = resultSet.getString("eventVenue"); // Added line

                EventModel event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image, eventLocation, eventVenue);
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
                    String eventLocation = resultSet.getString("eventLocation"); // Added line
                    String eventVenue = resultSet.getString("eventVenue"); // Added line

                    EventModel event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image, eventLocation, eventVenue);
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
                    String eventLocation = resultSet.getString("eventLocation"); // Added line
                    String eventVenue = resultSet.getString("eventVenue"); // Added line

                    event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image, eventLocation, eventVenue);
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
                    String eventLocation = resultSet.getString("eventLocation"); // Added line
                    String eventVenue = resultSet.getString("eventVenue"); // Added line

                    EventModel event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, eventRate, image, eventLocation, eventVenue);
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
    
    

}
