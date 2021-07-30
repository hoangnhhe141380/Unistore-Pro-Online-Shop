/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.OrderDAO;
import entity.Order;
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
@WebServlet(name = "AdminChangeStatusOrderSuccessController", urlPatterns = {"/adminChangeStatusOrderSuccess"})
public class AdminChangeStatusOrderSuccessController extends RequiredAdminAccount {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("oid"));

        OrderDAO db = new OrderDAO();
        Order o = db.getOrderByID(oid);

        o.setStatus("Success");

        db.updateOrder(o);

        response.sendRedirect("adminOrder");
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
