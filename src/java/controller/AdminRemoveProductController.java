/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import dal.ProductImageDAO;
import entity.Product;
import entity.Product_Image;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riel
 */
@WebServlet(name = "AdminRemoveProductController", urlPatterns = {"/removeProduct"})
public class AdminRemoveProductController extends RequiredAdminAccount {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        
        ProductDAO db = new ProductDAO();
        Product p = db.getProductByID(pid);
        
        ProductImageDAO pidb = new ProductImageDAO();
        for (Product_Image pi : p.getListImage()) {
            pidb.removeProductImage(pi);
        }
        
        db.removeProduct(pid);
        response.sendRedirect("adminProduct");
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
