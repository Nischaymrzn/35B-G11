package eventhub.controller;

import eventhub.database.DatabaseConnection;
import eventhub.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrganizerAddController {

    private DatabaseConnection dbConnection;

    public OrganizerAddController() {
        dbConnection = new DatabaseConnection();
    }

    public boolean addOrganizer(UserModel userModel) {
    String insertQuery = "INSERT INTO users (userName, userEmail, userPassword, userRole) VALUES (?, ?, ?, ?)";

    Connection connection = null;
    try {
        connection = dbConnection.openConnection();
        if (connection == null) {
            System.out.println("Failed to open connection");
            return false;
        }

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, userModel.getUserName());
        preparedStatement.setString(2, userModel.getUserEmail());
        preparedStatement.setString(3, userModel.getUserPassword());
        preparedStatement.setString(4, userModel.getUserRole());

        int result = preparedStatement.executeUpdate();
        return result > 0;
    } catch (SQLException e) {
        System.out.println(e);
        return false;
    } finally {
        // Ensure connection is closed properly
        if (connection != null) {
            dbConnection.closeConnection(connection);
        }
    }
}

}
