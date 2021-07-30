/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.OrderDAO;
import entity.Order;
import entity.Order_Detail;
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
@WebServlet(name = "AdminDetailOrderController", urlPatterns = {"/adminDetailOrder"})
public class AdminDetailOrderController extends RequiredAdminAccount {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        
        OrderDAO db = new OrderDAO();
        Order o = db.getOrderByID(oid);
        
        double total = 0;
        
        for (Order_Detail od : o.getListOrderDetail()) {
            total += od.getTotal();
        }
        
        request.setAttribute("o", o);
        request.setAttribute("total", total);
        request.getRequestDispatcher("./adminview/adminorderdetail.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
