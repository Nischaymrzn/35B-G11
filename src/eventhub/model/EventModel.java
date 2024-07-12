package eventhub.model;

public class EventModel {
    public final String eventId;
    public final String userId;
    public final String organizerId;
    public final String eventName;
    public final String eventType;

    public EventModel(String eventId, String userId, String organizerId, String eventName, String eventType) {
        this.eventId = eventId;
        this.userId = userId;
        this.organizerId = organizerId;
        this.eventName = eventName;
        this.eventType = eventType;
    }
}
