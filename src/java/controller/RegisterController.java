/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riel
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        //If password and confirm is not same
        if (!password.equals(confirm)) {
            request.setAttribute("checkRegister", true);
            request.setAttribute("error", "Password and repassword is not matched!");
            request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
            return;
        }

        AccountDAO db = new AccountDAO();

        //If email does not exist
        if (!db.checkEmailExisted(email)) {
            //Add new data
            try {
                Account account = new Account(email, password, false, name);
                db.addAccount(account);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

            //Go to login modal
            request.setAttribute("checkLogin", true);
            request.setAttribute("error", "Register successfully!");
            request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
        } else {
            //Else show messesge and go to register modal
            request.setAttribute("checkRegister", true);
            request.setAttribute("error", "Email is existed!");
            request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
        }
    }

}
