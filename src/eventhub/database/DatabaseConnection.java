package eventhub.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection implements Database{
    // private String url = "jdbc:mysql://127.0.0.1:3306/?user=root&password=admin123&useUnicode=true&characterEncoding=UTF-8";
   

    @Override
    public Connection openConnection() {
         String url = "jdbc:mysql://127.0.0.1:3306/eventhub";
         String username = "root";
         String password= "admin123";
         Connection connection;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
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
                openConnection();
            }
            return connection;

        }  catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void closeConnection(Connection connection){
        try {
            if(connection != null & !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @Override
    public ResultSet runQuery(Connection connection, String query){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e);
            return  null;
        }   
    }

    @Override
    public int executeUpdate(Connection connection, String query){
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }
    
}
