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
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, login.getEmail());
            pstmt.setString(2, login.getPassword());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                UserModel user = new UserModel(
                    result.getString("userName"),
                    result.getString("userEmail"),
                    result.getString("userPassword"),
                    result.getString("phoneNumber")
                );
                user.setUserId(result.getInt("userId"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            db.closeConnection(conn);
        }
        return null;
    }

    public boolean checkUser(UserModel user){
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM users where email = ? or username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserEmail());
            pstmt.setString(2, user.getUserName());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return false;
    }

    public void signup(UserModel user) {
        Connection conn = db.openConnection();
        
        String sql = "INSERT INTO users (username, email, password, phonenumber, role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserEmail());
            pstmt.setString(3, user.getUserPassword());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setString(3, user.getUserRole());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }
    
    public boolean udpate(UserModel user) {
        Connection conn = db.openConnection();
        
        String sql = "UPDATE users SET username = ?, email = ? where id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserEmail());
            pstmt.setInt(3, user.getUserId());
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
