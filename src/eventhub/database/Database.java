package eventhub.database;

import java.sql.*;

public interface  Database{
    Connection openConnection(); // Propagate exception for callers to handle.
    void closeConnection(Connection conn); // Propagate exception.
    ResultSet runQuery(Connection conn, String query); // Propagate exception.
    int executeUpdate(Connection conn, String query) ; // Propagate exception.
}