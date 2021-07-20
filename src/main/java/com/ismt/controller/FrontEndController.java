package com.ismt.controller;

import com.ismt.model.CartItem;
import com.ismt.model.Order;
import com.ismt.model.OrderedProduct;
import com.ismt.model.Product;
import com.ismt.repository.OrderRepo;
import com.ismt.repository.OrderedProductRepo;
import com.ismt.repository.ProductRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


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
            String pId = request.getParameter("productId");

            Double price = Double.parseDouble(request.getParameter("price"));

            String desc = request.getParameter("description");

            int quantity = 1;

            double total = price * quantity;

            HttpSession session = request.getSession();

            CartItem cart = new CartItem(pName, desc, price, quantity, total, Integer.parseInt(pId));

            boolean addIt = true;
            Set<CartItem> items = null;
            if (session.getAttribute("cart") != null) {
                items = (Set<CartItem>) session.getAttribute("cart");


                for (CartItem item : items) {
                    if (item.getProductName().equals(cart.getProductName())) {
                        item.setQuantity(item.getQuantity() + 1);
                        item.setItemTotal(item.getQuantity() * item.getPrice());
                        addIt = false;
                        break;
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

            session.setAttribute("total", calculateTotal(items));


            response.sendRedirect("/home");

        }

        if (request.getServletPath().equals("/checkout")) {
            RequestDispatcher view = request.getRequestDispatcher("checkout.jsp");
            view.forward(request, response);


        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        System.out.println(path);
        OrderRepo repo = new OrderRepo();
        int orderId=0;

        if (request.getServletPath().equals("/processOrder")) {

            String customerName = request.getParameter("customerName");
            String customerAddress = request.getParameter("customerAddress");
            String phoneNumber = request.getParameter("phoneNumber");


            Double orderTotal = (Double) request.getSession().getAttribute("total");

            Order order = new Order();
            order.setCustomerName(customerName);
            order.setBillingAddress(customerAddress);
            order.setPhoneNumber(phoneNumber);
            order.setOrder_number(generate());
            order.setTotal(orderTotal);


            try {
                orderId=repo.insert(order);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            OrderedProductRepo orderedProductRepo = new OrderedProductRepo();

            Set<CartItem> items = (Set<CartItem>) request.getSession().getAttribute("cart");



            for (CartItem item : items) {

                OrderedProduct op = new OrderedProduct();
                op.setOrder_id(orderId);
                op.setProduct_id(item.getProductId());
                op.setQuantity(item.getQuantity());


                try {
                    orderedProductRepo.insert(op);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }


            //clear all the cart items
            request.getSession().setAttribute("cart", null);
            request.getSession().setAttribute("total", null);


            //just to check whether cart is refreshed or not
            //request.getSession().getAttribute("cart");

            // we need to have order id as soon as order is saved to db.
            // int id =1;


            RequestDispatcher view = request.getRequestDispatcher("success.jsp");
            view.forward(request, response);


        }


    }

    private double calculateTotal(Set<CartItem> items) {
        double total = 0;
        for (CartItem item : items) {
            total += item.getItemTotal();
        }
        return total;

    }

    public String generate() {
        int num = ThreadLocalRandom.current().nextInt();
        return "ORD -" + num;
    }


}
