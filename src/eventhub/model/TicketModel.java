package eventhub.model;

interface  TicketModelInterface {
    public int getTicketId();
    public void setTicketId(int ticketId);
    public int getUserId();
    public void setUserId(int userId);
    public int getAdminId();
    public void setAdminId(int adminId);
    public int getEventId();
    public void setEventId(int eventId);
    public int getTicketRate();
    public void setTicketRate(int ticketRate);
}

public class TicketModel implements TicketModelInterface{
    private int ticketId;
    private int userId;
    private int adminId;
    private int eventId;
    private int ticketRate;

    public TicketModel(int ticketId, int userId, int adminId, int eventId, int ticketRate) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.adminId = adminId;
        this.eventId = eventId;
        this.ticketRate = ticketRate;
    }
    @Override
    public int getTicketId() {
        return ticketId;
    }
    @Override
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    @Override
    public int getUserId() {
        return userId;
    }
    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public int getAdminId() {
        return adminId;
    }
    @Override
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    @Override
    public int getEventId() {
        return eventId;
    }
    @Override
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    @Override
    public int getTicketRate() {
        return ticketRate;
    }
    @Override
    public void setTicketRate(int ticketRate) {
        this.ticketRate = ticketRate;
    }
 
}
