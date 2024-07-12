package eventhub.model;

public class EventModel {
    private  String eventId;
    private  String userId;
    private  String organizerId;
    private  String eventName;
    private  String eventType;

    public EventModel(String eventId, String userId, String organizerId, String eventName, String eventType) {
        this.eventId = eventId;
        this.userId = userId;
        this.organizerId = organizerId;
        this.eventName = eventName;
        this.eventType = eventType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
