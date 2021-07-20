package com.ismt.repository;

import com.ismt.JDBCUtils;
import com.ismt.model.Order;
import com.ismt.model.OrderedProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedProductRepo {


    public void insert(OrderedProduct orderedProduct) throws SQLException {
        final String INSERT_ORDERED_PRODUCT_SQL = "INSERT INTO orderedproduct " +
                "  (product_id, order_id,quantity) VALUES " +
                " (?, ?, ?);";
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
    public List<OrderedProduct> listOrderedProduct() {

        final String QUERY = "select * from ordered-product ";

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        List<OrderedProduct> orderedProduct = new ArrayList<>();
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
                String orderedProduct_number = rs.getString("orderedProduct_number");
                double total = rs.getDouble("total");

            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return orderedProduct;
    }

}

