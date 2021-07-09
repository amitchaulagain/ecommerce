package com.ismt.controller;

import com.ismt.model.Product;
import com.ismt.repository.ProductRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/ecommerce", "/checkout","/home"})
public class FrontEndController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ProductRepo productRepo= new ProductRepo();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path=request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/ecommerce")) {

            request.setAttribute("company", "ISMT E-Commerce App");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        }

        if (request.getServletPath().equals("/home")) {

        List<Product> products= productRepo.showAllProductsForFrontEnd();
            request.setAttribute("products",products);
            request.setAttribute("hello","hello");

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        }



    }
}
