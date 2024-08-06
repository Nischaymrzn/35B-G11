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
    public byte[] getImage();
    public void setImage(byte[] image);
    public String getEventDescription();
    public void setEventDescription(String eventDescription);
    public String getEventTime();
    public void setEventTime(String eventTime);
}

public class EventModel implements EventModelInterface {
    private int eventId;
    private int organizerId;
    private String eventName;
    private String eventType;
    private String eventDate;
    private String eventTime;
    private String eventDescription;
    private int eventRate;
    private byte[] image;

    public EventModel(int organizerId, String eventName, String eventType, String eventDate, String eventTime, String eventDescription, int eventRate, byte[] image) {
        this.organizerId = organizerId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventRate = eventRate;
        this.image = image;
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
    public byte[] getImage() {
        return image;
    }

    @Override
    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String getEventDescription() {
        return eventDescription;
    }

    @Override
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public String getEventTime() {
        return eventTime;
    }

    @Override
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
