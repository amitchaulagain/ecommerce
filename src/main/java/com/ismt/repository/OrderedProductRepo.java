package com.ismt.repository;

import com.ismt.JDBCUtils;
import com.ismt.model.OrderItem;
import com.ismt.model.OrderedProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedProductRepo {


    public void insert(OrderedProduct orderedProduct) throws SQLException {
        final String INSERT_ORDERED_PRODUCT_SQL = "INSERT INTO `ordered-product` " +
                "  (product_id, orders_id,quantity) VALUES " +
                " (?, ?, ?)";
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERED_PRODUCT_SQL)) {
            preparedStatement.setInt(1, orderedProduct.getProduct_id());
            preparedStatement.setInt(2, orderedProduct.getOrder_id());
            preparedStatement.setInt(3, orderedProduct.getQuantity());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }


    //TODO LATER
    public List<OrderItem> listOrderedProduct(int id) {

        final String QUERY = "select name,description,price,quantity from `ordered-product` op join `orders` o join product p where p.id=op.product_id and o.id=op.orders_id and orders_id=?";

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        List<OrderItem> orderedProduct = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                orderedProduct.add(new OrderItem(name, description, price, quantity));

            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return orderedProduct;
    }

}

