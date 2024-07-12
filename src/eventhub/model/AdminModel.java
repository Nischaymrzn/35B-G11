package eventhub.model;

public class AdminModel {
    public final String adminId;
    public final String adminName;
    public final String adminEmail;
    public final String adminPassword;


    public AdminModel(String adminId, String adminName, String adminEmail, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

}
