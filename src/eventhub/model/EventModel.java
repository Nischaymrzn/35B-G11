package eventhub.model;

interface EventModelInterface {
    public int getEventId();
    public void setEventId(int eventId);
    public int getUserId();
    public void setUserId(int userId);
    public int getOrganizerId();
    public void setOrganizerId(int organizerId);
    public String getEventName();
    public void setEventName(String eventName);
    public String getEventType();
    public void setEventType(String eventType);
}

public class EventModel implements EventModelInterface {
    private  int eventId;
    private  int userId;
    private  int organizerId;
    private  String eventName;
    private  String eventType;

    public EventModel(int eventId, int userId, int organizerId, String eventName, String eventType) {
        this.eventId = eventId;
        this.userId = userId;
        this.organizerId = organizerId;
        this.eventName = eventName;
        this.eventType = eventType;
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