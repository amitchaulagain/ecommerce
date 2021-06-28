package com.ismt.controller;

import com.ismt.model.User;
import com.ismt.repository.UserRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/signin", "/signup"})
public class LoginServlet extends HttpServlet {

    UserRepo userRepo = new UserRepo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;

        try {
            user = userRepo.checkLogin(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(!user.equals(null)){
            response.sendRedirect("/admin");
        }
        else{
            response.sendRedirect("/signin");

        }




    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/signin")) {

            RequestDispatcher view = request.getRequestDispatcher("login/signin.jsp");
            view.forward(request, response);

        }


    }

}
