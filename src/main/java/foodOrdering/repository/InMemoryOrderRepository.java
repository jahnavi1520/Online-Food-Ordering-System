package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.Order;
import main.java.foodOrdering.model.OrderStatus;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private int orderIdCounter = 1;

    public void save(Order order) {
        orders.add(order);
    }

    public Order findByOrderId(int orderId) {
        return orders.stream()
                .filter(o -> o.getOrderId() ==(orderId))
                .findFirst()
                .orElse(null);
    }

    public List<Order> findByUsername(String username) {
        return orders.stream()
                .filter(o -> o.getUsername().equals(username))
                .toList(); }

    public void updateStatus(int orderId, OrderStatus status) {
        Order order = findByOrderId(orderId);
        if (order != null) {
            order.setStatus(status);
        }
    }
}
