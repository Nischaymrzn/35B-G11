package eventhub.model;

public class UserModel {
    public final String userId;
    public final String userName;
    public final String userEmail;
    public final String phoneNumber;

    public UserModel(String userId,String userName, String userEmail, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }
}
