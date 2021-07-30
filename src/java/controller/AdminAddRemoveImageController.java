/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductImageDAO;
import entity.Product_Image;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riel
 */
@WebServlet(name = "AdminAddRemoveImageController", urlPatterns = {"/addRemoveImage"})
public class AdminAddRemoveImageController extends RequiredAdminAccount {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int imgid = Integer.parseInt(request.getParameter("imgid"));
        ProductImageDAO pidb = new ProductImageDAO();

        Product_Image pi = new Product_Image();
        pi.setPi_id(imgid);

        pidb.removeProductImage(pi);
        response.sendRedirect("adminProduct");
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        String image = request.getParameter("image");

        Product_Image pi = new Product_Image();
        pi.setPid(pid);
        pi.setImage(image);

        ProductImageDAO pidb = new ProductImageDAO();
        pidb.insertProductImage(pi);
        response.sendRedirect("adminProduct");
    }
}
