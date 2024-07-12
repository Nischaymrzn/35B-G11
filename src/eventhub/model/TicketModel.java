package eventhub.model;

public class TicketModel {
    public final String ticketId;
    public final String userId;
    public final String adminId;
    public final String eventId;
    public final String ticketRate;
    public final String eventDate;

    public TicketModel(String ticketId, String userId, String adminId, String eventId, String ticketRate, String eventDate) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.adminId = adminId;
        this.eventId = eventId;
        this.ticketRate = ticketRate;
        this.eventDate = eventDate;
    }
}
