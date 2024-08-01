package eventhub.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection implements Database{


    @Override
    public Connection openConnection() {
         String url = "jdbc:mysql://127.0.0.1:3306/eventhub";
         String username = "root";
         String password= "admin123";
         Connection connection;
         int flag = 0;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            flag++;
            if (connection != null) {
                System.out.println("Connected to the database");
                // Rest of the code...
            } else {
                // Handle the case when connection is null
                if(flag < 3){
                    openConnection();
                } else {
                    System.out.println("Connection failed");
                    
                }
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
