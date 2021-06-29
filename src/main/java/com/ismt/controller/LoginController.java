package com.ismt.controller;

import com.ismt.model.User;
import com.ismt.repository.UserRepo;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/signin", "/signup", "/login", "/login-user", "/register", "/createNewAccount"})
public class LoginController extends HttpServlet {

    UserRepo userRepo = new UserRepo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        if (request.getServletPath().equals("/login-user")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = null;

            try {
                user = userRepo.checkLogin(username, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (!(user.equals(null))) {
                //            request.setAttribute("userInfo", user);
                //            response.sendRedirect("/admin");
                HttpSession session = request.getSession();

                String name = user.getName();
                String role = user.getRole();
                session.setAttribute("userInfo", name + "  " + " " + "Role:" + role);
                response.sendRedirect("/admin");
            } else {
                response.sendRedirect("/login");
            }
        } else if (request.getServletPath().equals("/register")) {
            UserRepo userRepo =new UserRepo();
            String name = request.getParameter("name");
            String uname = request.getParameter("username");
            String pass = request.getParameter("password");
            String role = request.getParameter("role");



            response.sendRedirect("/admin");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/signin") || request.getServletPath().equals("/login")) {

            RequestDispatcher view = request.getRequestDispatcher("/login/login.jsp");
            view.forward(request, response);

        } else if (request.getServletPath().equals("/signup") || request.getServletPath().equals("/createNewAccount")) {

            RequestDispatcher signupPage = request.getRequestDispatcher("/login/signup.jsp");
            request.setAttribute("signupComment", "Register to get access");
            signupPage.forward(request, response);
        }

    }

}
