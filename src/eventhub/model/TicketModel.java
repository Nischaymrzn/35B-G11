package eventhub.model;

interface  TicketModelInterface {
    public int getTicketId();
    public void setTicketId(int ticketId);
    public int getUserId();
    public void setUserId(int userId);
    public int getOrganizerId();
    public void setOrganizerId(int OrganizerId);
    public int getEventId();
    public void setEventId(int eventId);
    public int getTicketAmount();
    public void setTicketAmount(int ticketAmount);
}

public class TicketModel implements TicketModelInterface{
    private int ticketId;
    private int userId;
    private int organizerId;
    private int eventId;
    private int ticketAmount;
  

    public TicketModel(int ticketId, int userId, int organizerId, int eventId, int ticketRate) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.organizerId = organizerId;
        this.eventId = eventId;
       
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
    public int getOrganizerId() {
        return organizerId;
    }
    @Override
    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
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
    public int getTicketAmount() {
        return ticketAmount;
    }
    @Override
    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
}
