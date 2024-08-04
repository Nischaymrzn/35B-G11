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
}
