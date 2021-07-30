/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/forgotpassword"})
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        AccountDAO db = new AccountDAO();
        Account account = db.getAccountByEmail(email);

        if (account != null) {
            if (!account.getName().equals(name)) {
                request.setAttribute("checkForgotPassword", true);
                request.setAttribute("error", "Email and name does not matched!");
                request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                request.setAttribute("checkRecovery", true);
                request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("checkForgotPassword", true);
            request.setAttribute("error", "Email does not existed!");
            request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
        }
    }

}
