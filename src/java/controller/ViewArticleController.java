/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import entity.Blog;
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
@WebServlet(name = "ViewArticleController", urlPatterns = {"/viewArticle"})
public class ViewArticleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BlogDAO db = new BlogDAO();
        
        int id = Integer.parseInt(request.getParameter("aid"));
        
        Blog blog = db.getBlogByID(id);
                
        request.setAttribute("blog", blog);
        
        request.getRequestDispatcher("./jsp/item-photo.jsp").forward(request, response);
    }
}
