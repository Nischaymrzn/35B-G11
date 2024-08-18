/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventhub.controller;

import eventhub.dao.Auth;
import eventhub.model.UserModel;
import eventhub.view.Signup;
import javax.swing.JOptionPane;
import eventhub.view.login;

/**
 * Controller for handling user registration logic.
 */
public class SignupController { 

    private Signup signupView;
    private Auth userDao;

    public SignupController(Signup signupView) {
        this.signupView = signupView;
        this.userDao = new Auth();
        initController();
    }

    private void initController() {
        // Add action listener for register button
        signupView.getRegisterButton().addActionListener(e -> registerUser());
    }

    private void registerUser() {
        // Retrieve user input from the view
        String fullName = signupView.getFullName().getText();
        String phoneNumber = signupView.getPhoneNumber().getText();
        String emailAddress = signupView.getEmailAddress().getText();
        String password = signupView.getPassword().getText();
        String confirmPassword = signupView.getConfirmPassword().getText();

        // Validate inputs
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(signupView, "Passwords do not match.");
            return;
        }

        // Create a new user model
        UserModel user = new UserModel(fullName, emailAddress, password);

        // Attempt to register the user
        boolean success = userDao.signup(user);
        if (success) {
            JOptionPane.showMessageDialog(signupView, "Registration successful!");
            signupView.dispose();
//             Optionally, redirect to the login page
            login newPage=new login();
            newPage.setVisible(true);
             
        } else {
            JOptionPane.showMessageDialog(signupView, "Registration failed. Please try again.");
        }
    }
}
