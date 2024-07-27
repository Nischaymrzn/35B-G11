package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.ReviewModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReviewOperations {
    DatabaseConnection db = new DatabaseConnection();

    public void addReview(ReviewModel review) {
        Connection conn = db.openConnection();
        String sql = "INSERT INTO reviews (reviewId,userId,reviewData) VALUES (?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, review.getReviewId());
            pstmt.setInt(1, review.getUserId());
            pstmt.setString(1, review.getReviewData());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public void deleteReview(int reviewId) {
        Connection conn = db.openConnection();
        String sql = "DELETE FROM reviews WHERE reviewId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reviewId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public ArrayList<ReviewModel>getAllReview(int reviewId){
        Connection conn = db.openConnection();
        ArrayList<ReviewModel> data = new ArrayList<>();
        String sql = "SELECT * FROM review";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                ReviewModel review  = new ReviewModel(
                    result.getInt("userId"),
                    result.getString("reviewData")
                );
                review.setReviewId(result.getInt("reviewId"));     
                data.add(review);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return data;
    }
}
