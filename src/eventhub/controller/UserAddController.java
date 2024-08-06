package eventhub.controller;

import eventhub.dao.Auth;
import eventhub.model.UserModel;
import eventhub.view.components.userAdd;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class UserAddController {
    private userAdd UserAdd;
    private Auth userDao;
    
    public UserAddController(userAdd UserAdd) {
        this.UserAdd = UserAdd;
        this.userDao = new Auth();
        initController();
    }

    private void initController() {
        // Add action listener for register button
        UserAdd.getAddUserButton().addActionListener(e -> {
            System.out.println("Add User button clicked");
            registerUser();
        });
    }

    private void registerUser() {
        // Retrieve user input from the view
        String fullName = UserAdd.getFullName().getText();
        String phoneNumber = UserAdd.getPhoneNumber().getText();
        String emailAddress = UserAdd.getEmailAddress().getText();
        String password = UserAdd.getPassword().getText();
        String confirmPassword = UserAdd.getConfirmPassword().getText();

        // Debug: Print inputs
        System.out.println("Full Name: " + fullName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Password: " + password);
        System.out.println("Confirm Password: " + confirmPassword);

        // Validate inputs
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(UserAdd, "Passwords do not match.");
            return;
        }

        // Create a new user model
        UserModel user = new UserModel(fullName, emailAddress, password);

        // Attempt to register the user
        boolean success = userDao.signup(user);
        if (success) {
            JOptionPane.showMessageDialog(UserAdd, "User Added successful!");
            UserAdd.dispose();
            // Optionally, redirect to the login page
            // new Login().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(UserAdd, "User Registration failed. Please try again.");
        }
    }
}
