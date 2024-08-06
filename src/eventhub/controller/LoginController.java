package eventhub.controller;

import eventhub.dao.Auth;
import eventhub.model.LoginModel;
import eventhub.model.UserModel;
import eventhub.view.admin.dashboard;
import eventhub.view.organizer.organizerDashboard;
import eventhub.view.user.homePage;
import eventhub.view.login;
import javax.swing.JOptionPane;

public class LoginController {
    private Auth auth;
    private login loginView;

    public LoginController(login loginView) {
        this.auth = new Auth();
        this.loginView = loginView;
        this.loginView.setLoginController(this);
    }

    public void login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LoginModel loginModel = new LoginModel(email, password);
        UserModel user = auth.login(loginModel);
        System.out.println(user);

        if (user != null) {
            JOptionPane.showMessageDialog(loginView, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            navigateToDashboard(user);
        } else {
            JOptionPane.showMessageDialog(loginView, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navigateToDashboard(UserModel user) {
        loginView.dispose(); // Close the login view

        switch (user.getUserRole()) {
            case "admin":
                new dashboard().setVisible(true);
                break;
            case "organizer":
                new organizerDashboard(user).setVisible(true);
                break;
            case "user":
                new homePage().setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Unknown role: " + user.getUserRole(), "Error", JOptionPane.ERROR_MESSAGE);
                new login().setVisible(true);
                break;
        }
    }
}
