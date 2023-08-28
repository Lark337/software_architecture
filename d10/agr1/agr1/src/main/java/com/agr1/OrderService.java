package com.agr1;

import java.sql.SQLException;

public class OrderService {
    private OrderRepository repository;


    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void createOrder(Order order) throws SQLException {
        repository.save(order);
    }

    public Order getOrderById(int id) throws SQLException {
        return repository.getById(id);
    }

}
