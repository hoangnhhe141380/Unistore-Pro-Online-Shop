/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.Item;
import java.io.IOException;
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
@WebServlet(name = "RemoveProductFromCartController", urlPatterns = {"/removeProductFromCart"})
public class RemoveProductFromCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        List<Item> listItems = cart.getItems();

        for (Iterator<Item> iter = listItems.listIterator(); iter.hasNext();) {
            Item item = iter.next();
            if (item.getProduct().getId() == pid) {
                iter.remove();
            }
        }
        request.getSession().setAttribute("cart", cart);
        response.sendRedirect("checkOut");
    }

}
