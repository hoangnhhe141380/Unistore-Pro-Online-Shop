/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.GalleryDAO;
import entity.Gallery;
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
@WebServlet(name = "GalleryController", urlPatterns = {"/gallery"})
public class GalleryController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GalleryDAO db = new GalleryDAO();
        List<Gallery> galleries = db.getAllGalleries();
        request.setAttribute("galleries", galleries);
        request.getRequestDispatcher("./jsp/gallery.jsp").forward(request, response);
    }

}
