package com.agr1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class OrderRepository {
    

    private Connection connection;
    public OrderRepository(String databaseUrl) throws SQLException {
        this.connection = DriverManager.getConnection(databaseUrl);
        initDatabase();
    }

    public void initDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS phones (id INTEGER PRIMARY KEY, name TEXT, brand TEXT, price REAL)");
        statement.execute("CREATE TABLE IF NOT EXISTS orders (id INTEGER PRIMARY KEY AUTOINCREMENT, totalAmount REAL)");
        statement.execute("CREATE TABLE IF NOT EXISTS order_items (orderId INTEGER, phoneId INTEGER, quantity INTEGER)");
        statement.close();
    }

    public void save(Order order) throws SQLException {
        connection.setAutoCommit(false);

        PreparedStatement orderStmt = connection.prepareStatement("INSERT INTO orders(totalAmount) VALUES (?)");
        orderStmt.setDouble(1, order.getTotalPrice());
        orderStmt.executeUpdate();
        ResultSet generatedKeys = orderStmt.getGeneratedKeys();
        int orderId = generatedKeys.getInt(1);
        generatedKeys.close();
        orderStmt.close();

        PreparedStatement itemStmt = connection.prepareStatement("INSERT INTO order_items(orderId, phoneId, quantity) VALUES (?, ?, ?)");
        for (OrderItem item : order.getItems()) {
            itemStmt.setInt(1, orderId);
            itemStmt.setInt(2, item.getPhone().getId());
            itemStmt.setInt(3, item.getQuantity());
            itemStmt.executeUpdate();
        }
        itemStmt.close();

        connection.commit();
        connection.setAutoCommit(true);
    }


    public Order getLastOrder() throws SQLException {
        String query = "SELECT * FROM orders ORDER BY id DESC LIMIT 1";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int orderId = resultSet.getInt("id");
            Order order = new Order();
            order.setItems(getOrderItemsByOrderId(orderId));

            return order;
        }

        return null;
    }


    public Order getById(int id) throws SQLException {
        Order order = new Order();
        order.setItems(getOrderItemsByOrderId(id));
        return order;
    }


    private List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException {
        List<OrderItem> orderItems = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM order_items WHERE orderId=?");
        stmt.setInt(1, orderId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int phoneId = rs.getInt("phoneId");
            int quantity = rs.getInt("quantity");
            Phone product = new Phone(phoneId, "Phone ","Brand", 30.0);
            orderItems.add(new OrderItem(product, quantity));
        }
        rs.close();
        stmt.close();

        return orderItems;
    }
}
