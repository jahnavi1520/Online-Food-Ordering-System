package main.java.foodOrdering.service;

import main.java.foodOrdering.Payment.PaymentStrategy;
import main.java.foodOrdering.model.Order;
import main.java.foodOrdering.model.OrderStatus;

import java.util.List;

public interface OrderService {
    int placeOrder(String username, PaymentStrategy paymentStrategy);

    List<Order> getOrderHistory(String username);

    Order getOrderById(int orderId);

    void updateOrderStatus(int orderId, OrderStatus status);

    void markDelivered(int orderId);
}
