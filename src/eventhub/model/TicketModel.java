package eventhub.model;

interface  TicketModelInterface {
    public String getTicketId();
    public void setTicketId(String ticketId);
    public String getUserId();
    public void setUserId(String userId);
    public String getAdminId();
    public void setAdminId(String adminId);
    public String getEventId();
    public void setEventId(String eventId);
    public String getTicketRate();
    public void setTicketRate(String ticketRate);
    public String getEventDate();
    public void setEventDate(String eventDate);
}

public class TicketModel implements TicketModelInterface{
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
    @Override
    public String getTicketId() {
        return ticketId;
    }
    @Override
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    @Override
    public String getUserId() {
        return userId;
    }
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String getAdminId() {
        return adminId;
    }
    @Override
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    @Override
    public String getEventId() {
        return eventId;
    }
    @Override
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    @Override
    public String getTicketRate() {
        return ticketRate;
    }
    @Override
    public void setTicketRate(String ticketRate) {
        this.ticketRate = ticketRate;
    }
    @Override
    public String getEventDate() {
        return eventDate;
    }
    @Override
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    
}
