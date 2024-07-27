package eventhub.dao;

import eventhub.database.DatabaseConnection;
import eventhub.model.CategoryModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryOperations {
    DatabaseConnection db = new DatabaseConnection();

    public void addCategory(CategoryModel category) {
        Connection conn = db.openConnection();
        String sql = "INSERT INTO categories (categoryId,categoryName) VALUES (?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, category.getCategoryId());
            pstmt.setString(1, category.getCategoryName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public void updateCategory(CategoryModel category) {
        Connection conn = db.openConnection();
        String sql = "UPDATE categories SET categoryName = ? WHERE categoryId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getCategoryName());
            pstmt.setInt(2, category.getCategoryId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public void deleteCategory(int categoryId) {
        Connection conn = db.openConnection();
        String sql = "DELETE FROM categories WHERE categoryId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, categoryId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
    }

    public CategoryModel getCategory(int categoryId) {
        Connection conn = db.openConnection();
        String sql = "SELECT * FROM categories WHERE categoryId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, categoryId);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                CategoryModel category = new CategoryModel(
                        result.getInt("categoryId"),
                        result.getString("categoryName")
                );
                return category;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return null;
    }

      public ArrayList<CategoryModel> getAllUserData(){
        Connection conn = db.openConnection();
        ArrayList<CategoryModel> data = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                CategoryModel category  = new CategoryModel(
                    result.getInt("categoryId"),
                    result.getString("categoryName")
                );                
                data.add(category);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(conn);
        }
        return data;
    }
}
