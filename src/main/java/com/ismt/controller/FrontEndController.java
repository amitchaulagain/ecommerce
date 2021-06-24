package com.ismt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
@WebServlet(urlPatterns = {"/ecommerce", "/checkout"})
public class FrontEndController extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path=request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/ecommerce")) {

            request.setAttribute("company", "ISMT E-Commerce App");
            request.setAttribute("test", "We are testing");

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        }
    }
}
