package eventhub.model;

interface OrganizerModelInterface {
    public int getOrganizerId();
    public void setOrganizerId(int organizerId);
    public int getAdminId();
    public void setAdminId(int adminId);
    public String getOrganizerName();
    public void setOrganizerName(String organizerName);
    public String getOrganizerEmail();
    public void setOrganizerEmail(String organizerEmail);
}

public class OrganizerModel implements OrganizerModelInterface {
    private  int organizerId;
    private  int adminId;
    private  String organizerName;
    private  String organizerEmail;

    public OrganizerModel(int organizerId, int adminId, String organizerName, String organizerEmail) {
        this.organizerId = organizerId;
        this.adminId = adminId;
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
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
    public int getAdminId() {
        return adminId;
    }
    @Override
    public void setAdminId(int adminId) {
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
