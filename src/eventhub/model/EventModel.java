package eventhub.model;

interface EventModelInterface {
    public int getEventId();
    public void setEventId(int eventId);
    public int getOrganizerId();
    public void setOrganizerId(int organizerId);
    public String getEventName();
    public void setEventName(String eventName);
    public String getEventType();
    public void setEventType(String eventType);
    public String getEventDate();
    public void setEventDate(String eventDate);
    public int getEventRate();
    public void setEventRate(int eventRate);
    public String getImageUrl();
    public void setImageUrl(String imageUrl);
}

public class EventModel implements EventModelInterface {
    private  int eventId;
    private  int organizerId;
    private  String eventName;
    private  String eventType;
    private  String eventDate;
    private int eventRate;
    private String imageUrl;

    public EventModel(int eventId, int organizerId, String eventName, String eventType, String eventDate, int eventRate, String imageUrl) {
        this.eventId = eventId;
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

    @Override
    public String getEventDate() {
        return eventDate;
    }
    @Override
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    @Override
    public int getEventRate() {
        return eventRate;
    }
    @Override
    public void setEventRate(int eventRate) {
        this.eventRate = eventRate;
    }
    @Override
    public String getImageUrl() {
        return imageUrl;
    }
    @Override
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
