/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DetailProductController", urlPatterns = {"/detailProduct"})
public class DetailProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        
        ProductDAO db = new ProductDAO();
        
        Product product = db.getProductByID(pid);
        
        request.setAttribute("product", product);
        
        List<Product> top4Products = db.getTopNewestProducts(4);
        
        request.setAttribute("top4Products", top4Products);
        
        request.getRequestDispatcher("./jsp/product.jsp").forward(request, response);
    }
}

//<!--                                                
//                                                <div class="carousel-product" data-count="4" data-current="1">
//                        
//                                                    <div class="items">
//                                                        <button class="btn btn-control" data-direction="right"> <i class="ion-ios-arrow-right"></i></button>
//                                                        <button class="btn btn-control" data-direction="left"> <i class="ion-ios-arrow-left"></i></button>
//                        
//                        
//                                                        <div class="item center" data-marker="1">
//                                                            <img src="${product.firstImage.image}" alt="" class="background"/>
//                                                        </div>
//                        
//                        <c:forEach var="o" items="${product.listImage}" begin="2">
//                            <div class="item" data-marker="${o.index}">
//                                <img src="${o.image}" alt="" class="background"/>
//                            </div>
//                        </c:forEach>
//
//
//
//                        <div class="item" data-marker="3">
//                            <img src="./assets/img/product/3.jpg" alt="" class="background"/>
//                        </div>
//
//                    </div>
//
//                    <ul class="markers">
//                        <li data-marker="1" class="active"></li>
//                        <li data-marker="2"></li>
//                        <li data-marker="3"></li>
//                        <li data-marker="4"></li>
//                    </ul>
//
//                </div>-->