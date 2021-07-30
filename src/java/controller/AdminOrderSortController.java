/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.OrderDAO;
import entity.Order;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riel
 */
@WebServlet(name = "AdminOrderSortController", urlPatterns = {"/adminOrderSort"})
public class AdminOrderSortController extends RequiredAdminAccount {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sort = Integer.parseInt(request.getParameter("sort"));
        
        OrderDAO db = new OrderDAO();
        List<Order> orders = db.getAllOrdersSort(sort);
        
        request.setAttribute("orders", orders);
        request.setAttribute("sortid", sort);
        request.getRequestDispatcher("./adminview/adminorder.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
