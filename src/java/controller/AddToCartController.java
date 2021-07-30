/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import entity.Cart;
import entity.Item;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Riel
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/add2Cart"})
public class AddToCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quantity = 1;
        int pid;

        ProductDAO db = new ProductDAO();

        if (request.getParameter("pid") != null) {
            pid = Integer.parseInt(request.getParameter("pid"));
            Product product = db.getProductByID(pid);
            //Check product exist in database or not
            if (product != null) {
                HttpSession session = request.getSession();
                //Check cart exist 
                //If cart not exist aka cart dont have anything
                if (session.getAttribute("cart") == null) {
                    Cart cart = new Cart();
                    List<Item> listItems = new ArrayList<>();
                    Item item = new Item();
                    item.setQuantity(quantity);
                    item.setProduct(product);
                    item.setPrice(product.getPrice());
                    listItems.add(item);
                    cart.setItems(listItems);
                    session.setAttribute("cart", cart);
                    
                //If cart exist aka already have any product
                } else {
                    Cart cart = (Cart) session.getAttribute("cart");
                    List<Item> listItems = cart.getItems();
                    //boolean variable check cart have this product or not
                    boolean checkExist = false;
                    for (Item item : listItems) {
                        //If cart already have
                        if (item.getProduct().getId() == product.getId()) {
                            //Increase quantity by 1
                            item.setQuantity(item.getQuantity() + quantity);
                            checkExist = true;
                        }
                    }
                    //If cart not have this product
                    if (checkExist == false) {
                        //Create and set quantity by 1
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setProduct(product);
                        item.setPrice(product.getPrice());
                        listItems.add(item);
                    }
                    //Update session cart
                    session.setAttribute("cart", cart);
                }
            }
            response.sendRedirect("checkOut");
        }
    }
}
