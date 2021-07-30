/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.OrderDAO;
import entity.Account;
import entity.Cart;
import entity.Item;
import entity.Order;
import entity.Order_Detail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riel
 */
@WebServlet(name = "ConfirmOrderController", urlPatterns = {"/confirmOrder"})
public class ConfirmOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //If not login then turn to login
        if (request.getSession().getAttribute("account") == null) {
            response.sendRedirect("login");
        } else  {
            //Check session cart one more time
            if (request.getSession().getAttribute("cart") != null) {
                Cart cart = (Cart) request.getSession().getAttribute("cart");
                List<Item> items = cart.getItems();
                //If in cart dont have any product then go to home page
                if (items.isEmpty()) {
                    response.sendRedirect("home");
                } else {
                    //Insert data of order to database
                    OrderDAO db = new OrderDAO();

                    Order order = new Order();

                    Account account = (Account) request.getSession().getAttribute("account");
                    order.setAccount(account);
                    order.setDate(Date.valueOf(LocalDate.now()));
                    order.setStatus("pending");

                    db.insertOrder(order);

                    Order o = db.getOrderAlreadyInserted();

                    for (Item item : items) {
                        Order_Detail order_detail = new Order_Detail();
                        order_detail.setProduct(item.getProduct());
                        order_detail.setQuantity(item.getQuantity());
                        order_detail.setPrice(item.getPrice());
                        order_detail.setTotal(order_detail.getQuantity() * order_detail.getPrice());
                        order_detail.setOid(o.getOid());

                        db.insertOrderDetail(order_detail);
                    }
                    
                    request.getSession().removeAttribute("cart");
                    response.sendRedirect("thankyou");
                }
            }
        }
    }
}
