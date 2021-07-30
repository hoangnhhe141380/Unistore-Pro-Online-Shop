/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Account;
import entity.Order;
import entity.Order_Detail;
import entity.Product;
import java.sql.Array;
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
public class OrderDAO extends db.DBContext {

    public void insertOrder(Order order) {
        String sql = "INSERT INTO [Order]\n"
                + "           ([date]\n"
                + "           ,[aid]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, order.getDate());
            stm.setInt(2, order.getAccount().getAid());
            stm.setString(3, order.getStatus());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Order getOrderAlreadyInserted() {
        String sql = "select top 1 * from [Order] order by oid desc";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Order order = new Order();
                order.setOid(rs.getInt("oid"));
                order.setDate(rs.getDate("date"));
                order.setStatus(rs.getString("status"));
                return order;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertOrderDetail(Order_Detail od) {
        String sql = "INSERT INTO [Order_Detail] ([oid],[pid],[quantity],[price],[total]) VALUES( ?,  ?,  ?,  ?,  ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, od.getOid());
            stm.setInt(2, od.getProduct().getId());
            stm.setInt(3, od.getQuantity());
            stm.setDouble(4, od.getPrice());
            stm.setDouble(5, od.getTotal());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "select * from [Order] o join Account a on o.aid = a.aid";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOid(rs.getInt("oid"));
                o.setDate(rs.getDate("date"));
                o.setStatus(rs.getString("status"));

                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setEmail(rs.getString("email"));
                a.setName(rs.getString("name"));
                a.setPhone(rs.getString("phone"));
                a.setAddress(rs.getString("address"));

                o.setAccount(a);
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public Order getOrderByID(int id) {
        Order o = new Order();
        List<Order_Detail> ods = new ArrayList<>();
        String sql = "select o.*, a.email, a.name, a.phone, a.[address], od.pid, od.price, od.quantity, od.total from [Order] o join Account a on o.aid = a.aid join Order_Detail od on o.oid = od.oid where o.oid =?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                o.setOid(rs.getInt("oid"));
                o.setDate(rs.getDate("date"));
                o.setStatus(rs.getString("status"));

                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setEmail(rs.getString("email"));
                a.setName(rs.getString("name"));
                a.setPhone(rs.getString("phone"));
                a.setAddress(rs.getString("address"));

                o.setAccount(a);

                ProductDAO db = new ProductDAO();
                Product p = db.getProductByID(rs.getInt("pid"));

                Order_Detail od = new Order_Detail();
                od.setProduct(p);
                od.setPrice(rs.getDouble("price"));
                od.setQuantity(rs.getInt("quantity"));
                od.setTotal(rs.getDouble("total"));

                ods.add(od);
            }
            o.setListOrderDetail(ods);
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateOrder(Order order) {
        String sql = "update [Order] set [status] = ? where oid = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, order.getStatus());
            stm.setInt(2, order.getOid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Order> getAllOrdersSort(int id) {
        List<Order> orders = new ArrayList<>();
        String sql = "select * from [Order] o join Account a on o.aid = a.aid ";
        switch (id) {
            case 1:
                sql += "order by o.oid";
                break;
            case 2:
                sql += "order by o.oid desc";
                break;
            case 3:
                sql += "order by o.[status]";
                break;
            case 4:
                sql += "order by o.[status] desc";
                break;
            default:
                break;
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOid(rs.getInt("oid"));
                o.setDate(rs.getDate("date"));
                o.setStatus(rs.getString("status"));

                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setEmail(rs.getString("email"));
                a.setName(rs.getString("name"));
                a.setPhone(rs.getString("phone"));
                a.setAddress(rs.getString("address"));

                o.setAccount(a);
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public static void main(String[] args) {
        OrderDAO db = new OrderDAO();
        List<Order> orders = db.getAllOrdersSort(3);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
