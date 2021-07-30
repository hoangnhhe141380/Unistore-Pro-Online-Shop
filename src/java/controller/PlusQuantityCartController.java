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
import java.util.Iterator;
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
@WebServlet(name = "PlusQuantityCartController", urlPatterns = {"/plus"})
public class PlusQuantityCartController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        List<Item> listItems = cart.getItems();
        
        for (Item listItem : listItems) {
            if (listItem.getProduct().getId() == pid) {
                listItem.setQuantity(listItem.getQuantity() + 1);
            }
        }
        request.getSession().setAttribute("cart", cart);
        response.sendRedirect("checkOut");
    }
}
