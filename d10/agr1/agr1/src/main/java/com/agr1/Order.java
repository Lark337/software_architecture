package com.agr1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;


    public Order() {
        this.items = new ArrayList<>();
    }


    public List<OrderItem> getItems() {
        return items;
    }


    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

 
    public void addItem(OrderItem item) {
        this.items.add(item);
    }


    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getPhone().getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
