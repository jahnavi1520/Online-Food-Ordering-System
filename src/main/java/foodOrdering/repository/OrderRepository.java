package main.java.foodOrdering.repository;


import main.java.foodOrdering.model.Order;
import main.java.foodOrdering.model.OrderStatus;

import java.util.List;

public interface OrderRepository {
    void save(Order order);

    List<Order> findByUsername(String username);

    Order findByOrderId(int orderId);

    void updateStatus(int orderId, OrderStatus status);
}
