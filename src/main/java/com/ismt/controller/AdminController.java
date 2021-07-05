package com.ismt.controller;

import com.ismt.model.Category;
import com.ismt.model.User;
import com.ismt.model.Order;
import com.ismt.model.Product;
import com.ismt.repository.CategoryRepo;
import com.ismt.repository.OrderRepo;
import com.ismt.repository.ProductRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/*
 * Update User
 *
 * List of users  ---> /users      ---->   /users     GET
 * Get by id      ---> /user?id=2&name=ram   ---->  /user?id=   GET
 * create         ---> /user  ---->/user?country=us        POST
 * update         ---> /user            ----> /user        PUT
 * delete         ---> /user  ----> /user?id=   DELETE
 *
 *
 * */
@WebServlet(urlPatterns = {"/category", "/product", "/order", "/admin"})
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryRepo categoryRepo = new CategoryRepo();
    ProductRepo productRepo =new ProductRepo();
    OrderRepo orderRepo = new OrderRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/category") || request.getServletPath().equals("/admin")) {



            request.setAttribute("entity", "Category");
            List<Category> categories = categoryRepo.list();
            request.setAttribute("categoryList", categories);

            RequestDispatcher view = request.getRequestDispatcher("admin/category/category-admin.jsp");
            view.forward(request, response);

        } else if (request.getServletPath().equals("/product")) {

            request.setAttribute("entity", "Product");
            List<Product> products = productRepo.listProduct();
            request.setAttribute("productList", products);
            RequestDispatcher view = request.getRequestDispatcher("admin/product/product-admin.jsp");
            view.forward(request, response);
        }
         else if (request.getServletPath().equals("/order")) {

            request.setAttribute("entity", "Order");
            List<Order> orders = orderRepo.listOrder();
            request.setAttribute("orderList",orders);
            RequestDispatcher view = request.getRequestDispatcher("admin/order/order-admin.jsp");
            view.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/category")) {

            Category user = getCategoryData(request);

            try {
                categoryRepo.insert(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/category");

        }


    }

    private Category getCategoryData(HttpServletRequest request) {
        Category category = new Category();
        category.setId(Integer.parseInt(request.getParameter("id")));
        category.setName(request.getParameter("name"));
        category.setDescription(request.getParameter("description"));
        return category;
    }


}
