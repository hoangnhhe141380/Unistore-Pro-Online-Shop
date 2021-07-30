/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Order;
import entity.Product_Image;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riel
 */
public class ProductImageDAO extends db.DBContext {

    public void insertProductImage(Product_Image pi) {
        String sql = "INSERT INTO Product_Image (pimage, pid)\n"
                + "VALUES (?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pi.getImage());
            stm.setInt(2, pi.getPid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeProductImage(Product_Image pi) {
        String sql = "DELETE FROM Product_Image WHERE pi_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pi.getPi_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
