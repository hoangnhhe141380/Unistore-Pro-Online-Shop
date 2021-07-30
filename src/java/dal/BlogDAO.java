/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Blog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riel
 */
public class BlogDAO extends db.DBContext {

    public List<Blog> getAllBlogs() {
        List<Blog> blogs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Blog";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setName(rs.getString("name"));
                blog.setDescription(rs.getString("description"));
                blog.setDate(rs.getDate("date"));
                blog.setImage(rs.getString("image"));
                blogs.add(blog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }
    
     public Blog getBlogByID(int id) {
        try {
            String sql = "SELECT * FROM Blog where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setName(rs.getString("name"));
                blog.setDescription(rs.getString("description"));
                blog.setDate(rs.getDate("date"));
                blog.setImage(rs.getString("image"));
                return blog;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
