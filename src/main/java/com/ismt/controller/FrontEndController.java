package com.ismt.controller;

import com.ismt.model.CartItem;
import com.ismt.model.Product;
import com.ismt.repository.ProductRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
@WebServlet(urlPatterns = {"/ecommerce", "/checkout", "/home", "/cart", "/addToCart", "/processOrder"})
public class FrontEndController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ProductRepo productRepo = new ProductRepo();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/ecommerce")) {

            request.setAttribute("company", "ISMT E-Commerce App");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        }

        if (request.getServletPath().equals("/home")) {

            List<Product> products = productRepo.showAllProductsForFrontEnd();
            request.setAttribute("products", products);
            request.setAttribute("hello", "hello");

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        }


        if (request.getServletPath().equals("/cart")) {

            RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
            view.forward(request, response);

        }

        if (request.getServletPath().equals("/addToCart")) {

            String pName = request.getParameter("productName");

            Double price = Double.parseDouble(request.getParameter("price"));

            String desc = request.getParameter("description");

            int quantity = 1;

            double total = price * quantity;

            HttpSession session = request.getSession();

            CartItem cart = new CartItem(pName, desc, price, quantity, total);

            boolean addIt = false;
            Set<CartItem> items = null;
            if (session.getAttribute("cart") != null) {
                items = (Set<CartItem>) session.getAttribute("cart");


                for (CartItem item : items) {
                    if (item.getProductName().equals(cart.getProductName())) {
                        item.setQuantity(item.getQuantity() + 1);
                    } else {
                        if (cart.getQuantity() == 1) {
                            addIt = true;
                        }
                    }
                }
                if (addIt) {
                    items.add(cart);
                }

            } else {
                items = new HashSet<>();
                items.add(cart);
                session.setAttribute("cart", items);

            }
            response.sendRedirect("/home");

        }

        if (request.getServletPath().equals("/processOrder")) {
            Set<CartItem> items = null;
            items = (Set<CartItem>) request.getSession().getAttribute("cart");

        }


    }
}
