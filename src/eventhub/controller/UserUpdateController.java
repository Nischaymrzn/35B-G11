package eventhub.controller;

import eventhub.dao.UserOperations;
import eventhub.model.UserModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserUpdateController {

    private UserOperations userOps = new UserOperations();

    // Constructor
    public UserUpdateController() {
        // Any initialization if needed
    }

    // Method to update an existing organizer's information
    public boolean updateUser(UserModel userModel) {
        if (userModel == null || userModel.getUserId() <= 0 || userModel.getUserName() == null || userModel.getUserEmail() == null) {
            return false;
        }

        try {
            // Use the existing updateUser method from UserOperations
            userOps.updateUser(userModel);
            return true; // Return true if the update is successful
        } catch (Exception ex) {
            Logger.getLogger(UserUpdateController.class.getName()).log(Level.SEVERE, "Failed to update organizer", ex);
            return false; // Return false if there is an error
        }
    }
}
