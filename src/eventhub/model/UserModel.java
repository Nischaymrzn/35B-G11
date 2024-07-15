package eventhub.model;

interface  UserModelInterface {
    public String getUserId();
    public void setUserId(String userId);
    public String getUserName();
    public void setUserName(String userName);
    public String getUserEmail();
    public void setUserEmail(String userEmail);
    public String getPhoneNumber();
    public void setPhoneNumber(String phoneNumber);
}  

public class UserModel implements UserModelInterface {
    private String userId;
    private String userName;
    private String userEmail;
    private String phoneNumber;

    public UserModel(String userId,String userName, String userEmail, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String getUserId() {
        return userId;
    }
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String getUserName() {
        return userName;
    }
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String getUserEmail() {
        return userEmail;
    }
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
