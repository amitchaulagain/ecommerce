package com.ismt.repository;

import com.ismt.JDBCUtils;
import com.ismt.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo {


    public int insert(Order order) throws SQLException {
        int orderId = 0;
        final String INSERT_USERS_SQL = "INSERT INTO orders" +
                "  (id, order_number,customer_name,billing_address,phone, total) VALUES " +
                " (?, ?, ?,?,?,?)";
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getOrderNumber());
            preparedStatement.setString(3, order.getCustomerName());
            preparedStatement.setString(4, order.getBillingAddress());
            preparedStatement.setString(5, order.getPhoneNumber());
            preparedStatement.setDouble(6, order.getTotal());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                orderId = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orderId;


    }

    public List<Order> listOrder() {

        final String QUERY = "select * from orders ";

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        List<Order> order = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String order_number = rs.getString("order_number");
                String customer_name = rs.getString("customer_name");
                String billing_address = rs.getString("billing_address");
                String phone = rs.getString("phone");

                double total = rs.getDouble("total");
                order.add(new Order(id, order_number, total,customer_name,billing_address,phone ));
            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return order;
    }

    public void delete(int id) {
        final String QUERY = "delete from orders where id=? ";

        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, id);
            // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

            // Step 4: Process the ResultSet object.
         /*  while (rs.next()) {
                int id = rs.getInt("id");
                String order_number = rs.getString("order_number");
                String total = rs.getString("total");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + order_number + "," + total + "," + country + "," + password);
           }*/
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
    }

    public Order getById(int id) {
        final String QUERY = "select * from orders where id =?";
        Order order = null;
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            // while (rs.next()) {
            rs.next();
            int categoryId = rs.getInt("id");
            String order_number = rs.getString("order_number");
            double total = rs.getDouble("total");
            System.out.println(id + "," + order_number + "," + total);
          //  order = new Order(categoryId, order_number, total);

            //}
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return order;
    }


    public Order getByOrderNumber(String orderNumber) {
        final String QUERY = "select * from orders where order_number =?";
        Order order = null;
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setString(1, orderNumber);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            // while (rs.next()) {
            rs.next();
            int id = rs.getInt("id");
            String order_number = rs.getString("order_number");
            double total = rs.getDouble("total");
            String customerName = rs.getString("customer_name");
            String billingAddress = rs.getString("billing_address");
            String phone = rs.getString("phone");


            order.setId(id);
            order.setOrderNumber(order_number);

            order.setTotal(total);

            order.setCustomerName(customerName);
            order.setBillingAddress(billingAddress);
            order.setPhoneNumber(phone);


            //}
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return order;
    }


    public void edit(Order order) {

        final String UPDATE_USERS_SQL = "update orders set order_number = ?, total=? where id = ?;";
        // Step 1: Establishing a Connection

        System.out.println("trying to establish connection");
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getOrderNumber());
            preparedStatement.setDouble(3, order.getTotal());

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }

    }


    /*public static int createOrder(Double total_cost, int customer_id, String shipping_address, String phone,
                                  String payment_method) {
        int order_id = 0;
        String query = "insert into orders(total_cost, customer_id, shipping_address, phone, payment_method) values(?, ? ,?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, total_cost);
            ps.setInt(2, customer_id);
            ps.setString(3, shipping_address);
            ps.setString(4, phone);
            ps.setString(5, payment_method);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                order_id = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order_id;
    }*/
}

