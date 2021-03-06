/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import entity.Product;
import entity.Product_Image;
import java.io.IOException;
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
@WebServlet(name = "AdminEditImageProductController", urlPatterns = {"/adminEditImage"})
public class AdminEditImageProductController extends RequiredAdminAccount {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        
        ProductDAO db = new ProductDAO();
        Product p = db.getProductByID(pid);
        
        List<Product_Image> images = db.getListImageByPid(pid);
        
        request.setAttribute("images", images);
        request.setAttribute("product", p);
        request.getRequestDispatcher("./adminview/admineditimageproduct.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
