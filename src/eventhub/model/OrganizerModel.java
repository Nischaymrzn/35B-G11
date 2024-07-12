package eventhub.model;

public class OrganizerModel {
    public final String organizerId;
    public final String adminId;
    public final String organizerName;
    public final String organizerEmail;

    public OrganizerModel(String organizerId, String adminId, String organizerName, String organizerEmail) {
        this.organizerId = organizerId;
        this.adminId = adminId;
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
    }

}
