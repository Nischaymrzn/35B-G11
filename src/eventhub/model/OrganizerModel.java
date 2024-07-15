package eventhub.model;

interface OrganizerModelInterface {
    public String getOrganizerId();
    public void setOrganizerId(String organizerId);
    public String getAdminId();
    public void setAdminId(String adminId);
    public String getOrganizerName();
    public void setOrganizerName(String organizerName);
    public String getOrganizerEmail();
    public void setOrganizerEmail(String organizerEmail);
}

public class OrganizerModel implements OrganizerModelInterface {
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
    @Override
    public String getOrganizerId() {
        return organizerId;
    }

    @Override
    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }
    @Override
    public String getAdminId() {
        return adminId;
    }
    @Override
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    @Override
    public String getOrganizerName() {
        return organizerName;
    }
    @Override
    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
    @Override
    public String getOrganizerEmail() {
        return organizerEmail;
    }
    @Override
    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }


}
