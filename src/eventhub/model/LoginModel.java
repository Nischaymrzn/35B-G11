package eventhub.model;

interface LoginModelInterface {
    public String getEmail();
    public void setEmail(String email);
    public String getPassword();
    public void setPassword(String password);
}

public class LoginModel implements LoginModelInterface {
    private String email;
    private String password;

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
}
