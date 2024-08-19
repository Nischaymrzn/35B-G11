package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.UserModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserOperations {

    DatabaseConnection db = new DatabaseConnection();

    public String checkRole(UserModel user){
        Connection conn = db.openConnection();
        String sql = "SELECT userRole FROM users WHERE userEmail = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, user.getUserEmail());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                return result.getString("userRole");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.closeConnection(conn);
        }
        return null;
    }
    
    public void deleteUser(int userId) {
    Connection conn = db.openConnection();
    String sql = "DELETE FROM users WHERE userId = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, userId);
        int affectedRows = pstmt.executeUpdate();
        // If affectedRows > 0, that means the deletion was successful
        
    } catch (SQLException ex) {
        Logger.getLogger(UserOperations.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        db.closeConnection(conn);
    }
  
}


    public UserModel getUser(int userId){
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM users WHERE userId = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, userId);
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                UserModel user = new UserModel(
                    result.getString("userName"),
                    result.getString("userEmail"),
                    result.getString("userPassword")
                );
                user.setUserRole(result.getString("userRole"));
                user.setUserPassword(null);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.closeConnection(conn);
        }
        return null;
    }

    public ArrayList<UserModel> getAllOrganizers(){
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM users WHERE userRole = 'organizer'";
        ArrayList<UserModel> organizers = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                UserModel user = new UserModel(
                    result.getString("userName"),
                    result.getString("userEmail"),
                    result.getString("userPassword")
                );
                user.setUserId(result.getInt("userId"));
                user.setUserRole(result.getString("userRole"));
                user.setUserPassword(null);
                organizers.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.closeConnection(conn);
        }
        return organizers;
    }
    
     public ArrayList<UserModel> getAllClients(){
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM users WHERE userRole = 'user'";
        ArrayList<UserModel> clients = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                UserModel user = new UserModel(
                    result.getString("userName"),
                    result.getString("userEmail"),
                    result.getString("userPassword")
                );
                user.setUserId(result.getInt("userId"));
                user.setUserRole(result.getString("userRole"));
                user.setUserPassword(null);
                clients.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.closeConnection(conn);
        }
        return clients;
    }
     
     public void updateUser(UserModel user) {
        Connection conn = db.openConnection();
        String sql = "UPDATE users SET userName = ?, userEmail = ?, userPassword = ?, userRole = ? WHERE userId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserEmail());
            pstmt.setString(3, user.getUserPassword());
            pstmt.setString(4, user.getUserRole());
            pstmt.setInt(5, user.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }
}
