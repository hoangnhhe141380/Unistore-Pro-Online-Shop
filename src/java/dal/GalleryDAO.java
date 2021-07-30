/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Category;
import entity.Gallery;
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
public class GalleryDAO extends db.DBContext{
    public List<Gallery> getAllGalleries() {
        List<Gallery> galleries = new ArrayList<>();
        try {
            String sql = "select * from Gallery";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setGid(rs.getInt("gid"));
                gallery.setGimage(rs.getString("gimage"));

                galleries.add(gallery);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return galleries;
    }
}
