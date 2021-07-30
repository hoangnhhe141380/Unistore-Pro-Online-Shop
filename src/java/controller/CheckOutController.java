/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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
@WebServlet(name = "CheckOutController", urlPatterns = {"/checkOut"})
public class CheckOutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Item> i = new ArrayList<>();
        Cart c = new Cart();
        c.setItems(i);
        double total = 0;
        if (request.getSession().getAttribute("cart") == null) {
            request.getSession().setAttribute("cart", c);
            request.setAttribute("total", total);
        } else {
            c = (Cart) request.getSession().getAttribute("cart");
            List<Item> items = c.getItems();
            for (Item item : items) {
                total += item.getPrice() * item.getQuantity();
            }
            NumberFormat formatter = new DecimalFormat("#0.00");
            total = Double.parseDouble(formatter.format(total));
            request.setAttribute("total", total);
        }
        request.getRequestDispatcher("./jsp/checkout.jsp").forward(request, response);
    }
}
