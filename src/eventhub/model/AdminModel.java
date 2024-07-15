package eventhub.model;

interface AdminModelInterface {
    public String getAdminId();
    public void setAdminId(String adminId);
    public String getAdminName();
    public void setAdminName(String adminName);
    public String getAdminEmail();
    public void setAdminEmail(String adminEmail);
    public String getAdminPassword();
    public void setAdminPassword(String adminPassword);
}

public class AdminModel implements AdminModelInterface {
    private String adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;


    public AdminModel(String adminId, String adminName, String adminEmail, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
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
    public String getAdminName() {
        return adminName;
    }
    @Override
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    @Override
    public String getAdminEmail() {
        return adminEmail;
    }
    @Override
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
    @Override
    public String getAdminPassword() {
        return adminPassword;
    }
    @Override
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}
