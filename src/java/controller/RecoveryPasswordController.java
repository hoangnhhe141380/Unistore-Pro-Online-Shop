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
@WebServlet(name = "RecoveryPasswordController", urlPatterns = {"/recovery"})
public class RecoveryPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (password.equals(confirm)) {
            AccountDAO db = new AccountDAO();
            account.setPassword(password);
            db.updateAccount(account);
            
            session.removeAttribute("account");

            request.setAttribute("checkLogin", true);
            request.setAttribute("error", "Recovery successfully!");
            request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
        } else {
            request.setAttribute("checkRecovery", true);
            request.setAttribute("error", "Password and repassword is not matched!");
            request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
        }

    }

}
