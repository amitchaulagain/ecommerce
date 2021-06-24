package com.ismt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hero")
public class HeroServlet extends HttpServlet {

    private static final long serialVersionUID = 1533532266743443618L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {

//        response.setContentType("text/html");
//
//
//        DateTime dateTime = new DateTime();
//        System.out.println(dateTime);
//
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html><body><h1>Hello <p>You are hero</p></body></html>");
//        }


        request.setAttribute("company", "ISMT E-Commerce App");
        RequestDispatcher view = request.getRequestDispatcher("success.jsp");
        view.forward(request, response);











    }
}
