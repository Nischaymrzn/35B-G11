package eventhub.model;

interface EventModelInterface {
    public String getEventId();
    public void setEventId(String eventId);
    public String getUserId();
    public void setUserId(String userId);
    public String getOrganizerId();
    public void setOrganizerId(String organizerId);
    public String getEventName();
    public void setEventName(String eventName);
    public String getEventType();
    public void setEventType(String eventType);
}

public class EventModel implements EventModelInterface {
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
    @Override
    public String getEventId() {
        return eventId;
    }
    @Override
    public void setEventId(String eventId) {
        this.eventId = eventId;
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
    public String getOrganizerId() {
        return organizerId;
    }
    @Override
    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }
    @Override
    public String getEventName() {
        return eventName;
    }
    @Override
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    @Override
    public String getEventType() {
        return eventType;
    }
    @Override
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
