package eventhub.model;

public class TicketModel {
    private String ticketId;
    private String userId;
    private String adminId;
    private String eventId;
    private String ticketRate;
    private String eventDate;

    public TicketModel(String ticketId, String userId, String adminId, String eventId, String ticketRate, String eventDate) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.adminId = adminId;
        this.eventId = eventId;
        this.ticketRate = ticketRate;
        this.eventDate = eventDate;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTicketRate() {
        return ticketRate;
    }

    public void setTicketRate(String ticketRate) {
        this.ticketRate = ticketRate;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    
}
