package eventhub.model;

interface  UserModelInterface {
    public int getUserId();
    public void setUserId(int userId);
    public String getUserName();
    public void setUserName(String userName);
    public String getUserEmail();
    public void setUserEmail(String userEmail);
    public String getUserPassword();
    public void setUserPassword(String userPassword);
    public String getUserRole();
    public void setUserRole(String userRole);
}  

public class UserModel implements UserModelInterface {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userRole;
    public UserModel(){
        
    }
    public UserModel(String userName, String userEmail,String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    // New constructor with user role
    public UserModel(String userName, String userEmail, String userPassword, String userRole) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }
     public UserModel(int userId,String userName, String userEmail, String userPassword, String userRole) {
         this.userId=userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }
    @Override
    public int getUserId() {
        return userId;
    }
    @Override
    public void setUserId(int userId) {
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
    public String getUserPassword() {
        return userPassword;
    }
    @Override
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    @Override
    public String getUserRole() {
        return userRole;
    }
    @Override
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
