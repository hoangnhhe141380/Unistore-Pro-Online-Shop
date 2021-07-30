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
@WebServlet(name = "AdminEditProductController", urlPatterns = {"/adminEditProduct"})
public class AdminEditProductController extends RequiredAdminAccount {
    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        
        ProductDAO db = new ProductDAO();
        Product p = db.getProductByID(pid);
        
        request.setAttribute("product", p);
        
        CategoryDAO cdb = new CategoryDAO();
        List<Category> categories = cdb.getAllCategories();
        
        request.setAttribute("categories", categories);
        
        request.getRequestDispatcher("./adminview/admineditproduct.jsp").forward(request, response);
        
    }
    
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int quantity_stock = Integer.parseInt(request.getParameter("quantity_stock"));
        String operating_system = request.getParameter("operating_system");
        String display_resolution = request.getParameter("display_resolution");
        String processor = request.getParameter("processor");
        String processor_technology = request.getParameter("processor_technology");
        String graphics = request.getParameter("graphics");
        String memory = request.getParameter("memory");
        String hard_drive = request.getParameter("hard_drive");
        String wireless = request.getParameter("wireless");
        String power_supply = request.getParameter("power_supply");
        String battery = request.getParameter("battery");
        int cateid = Integer.parseInt(request.getParameter("cateid"));
        
        ProductDAO db = new ProductDAO();
        
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setQuantity_stock(quantity_stock);
        product.setOperating_system(operating_system);
        product.setDisplay_resolution(display_resolution);
        product.setProcessor(processor);
        product.setProcessor_technology(processor_technology);
        product.setGraphics(graphics);
        product.setMemory(memory);
        product.setHard_drive(hard_drive);
        product.setWireless(wireless);
        product.setPower_supply(power_supply);
        product.setBattery(battery);
        
        Category category = new Category();
        category.setCid(cateid);
        
        product.setCategory(category);
        
        db.updateProduct(product);
        response.sendRedirect("adminProduct");
    }
}
