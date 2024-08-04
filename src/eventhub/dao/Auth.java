package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.LoginModel;
import eventhub.model.UserModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Auth {
    DatabaseConnection db = new DatabaseConnection();
    
    public UserModel login(LoginModel login){
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM users WHERE userEmail = ? AND userPassword = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, login.getEmail());
            pstmt.setString(2, login.getPassword());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                UserModel user = new UserModel(
                    result.getString("userName"),
                    result.getString("userEmail"),
                    result.getString("userPassword")
                );
                user.setUserId(result.getInt("userId"));
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

    public boolean checkUser(UserModel user){
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM users where userEmail = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserEmail());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return false;
    }

    public boolean signup(UserModel user) {
        Connection conn = db.openConnection();
        
        String sql = "INSERT INTO users (userId,userName, userEmail, userPassword) VALUES (?,?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setString(4, user.getUserPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return false;
    }
    
    public boolean udpatePassword(UserModel user) {
        Connection conn = db.openConnection();
        
        String sql = "UPDATE users SET userPassword = ? where id = ? or email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserPassword());
            pstmt.setInt(2, user.getUserId());
            pstmt.setString(3, user.getUserEmail());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return false;
    }
    
    public boolean delete(UserModel user) {
        Connection conn = db.openConnection();
        
        String sql = "DELETE from users where id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getUserId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return false;
    }
}
