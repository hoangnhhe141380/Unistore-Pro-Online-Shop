/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import entity.Category;
import entity.Product;
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
@WebServlet(name = "StoreController", urlPatterns = {"/store"})
public class StoreController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO db = new ProductDAO();

        int cateid = Integer.parseInt(request.getParameter("cid"));
        int sortid = Integer.parseInt(request.getParameter("sortid"));

        final int PRODUCT_PAGE = 6;

        int pageCurrent = Integer.parseInt(request.getParameter("page"));

        List<Product> allProducts = db.getProductByPageAndCategoryAndSort(pageCurrent, cateid, sortid, PRODUCT_PAGE);

        int numberPage = db.getNumberPageByCategory(cateid, PRODUCT_PAGE);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("pageCurrent", pageCurrent);

        request.setAttribute("allProducts", allProducts);
        request.setAttribute("cateid", cateid);
        request.setAttribute("sortid", sortid);

        request.getRequestDispatcher("./jsp/store.jsp").forward(request, response);
    }
}
