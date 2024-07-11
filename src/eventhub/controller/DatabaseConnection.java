package eventhub.controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    // private String url = "jdbc:mysql://127.0.0.1:3306/?user=root&password=admin123&useUnicode=true&characterEncoding=UTF-8";
    private String url = "jdbc:mysql://127.0.0.1:3306/eventhub";
    private String username = "root";
    private String password= "admin123";

    public DatabaseConnection() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SHOW DATABASES LIKE 'eventhub'");
                if (resultSet.next()) {
                    System.out.println("Database 'eventhub' exists.");
                } else {
                    statement.execute("CREATE DATABASE IF NOT EXISTS eventhub");
                }
                // Rest of the code...
            } else {
                // Handle the case when connection is null
                DatabaseConnection db =  new DatabaseConnection();
            }


        }  catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
