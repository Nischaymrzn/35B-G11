package eventhub.model;

public class OrganizerModel {
    private  String organizerId;
    private  String adminId;
    private  String organizerName;
    private  String organizerEmail;

    public OrganizerModel(String organizerId, String adminId, String organizerName, String organizerEmail) {
        this.organizerId = organizerId;
        this.adminId = adminId;
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerId() {
        return organizerId;
    }


    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }


}
