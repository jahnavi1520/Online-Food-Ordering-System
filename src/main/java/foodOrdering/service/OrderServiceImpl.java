package main.java.foodOrdering.service;

import main.java.foodOrdering.Notification.NotificationManager;
import main.java.foodOrdering.Payment.PaymentStrategy;
import main.java.foodOrdering.model.Cart;
import main.java.foodOrdering.model.Order;
import main.java.foodOrdering.model.OrderStatus;
import main.java.foodOrdering.repository.CartRepository;
import main.java.foodOrdering.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final NotificationManager notificationManager;
    private static int orderIdCounter = 1;

    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository, NotificationManager notificationManager) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.notificationManager = notificationManager;
    }

    @Override
    public int placeOrder(String username, PaymentStrategy paymentStrategy) {

        Cart cart = cartRepository.getCart(username);

        if (cart == null || cart.getItems().isEmpty()) {
            System.out.println("Cart is empty. Please add items before ordering.");
            return -1;
        }


        int orderId = orderIdCounter++;
        double total = cart.getTotal();

        boolean paymentSuccess = paymentStrategy.pay(orderId, total);

        if (!paymentSuccess) {
            throw new RuntimeException("Payment failed");
        }

        Order order = new Order(orderId, username, total);
        order.setItems(List.copyOf(cart.getItems()));

        orderRepository.save(order);
        notificationManager.notifyObservers(order);
        cartRepository.clearCart(username);

        System.out.println("Order placed successfully: " + orderId);
        return orderId;
    }

    public List<Order> getOrderHistory(String username) {
        return orderRepository.findByUsername(username);
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public void updateOrderStatus(int orderId, OrderStatus status) {
        orderRepository.updateStatus(orderId, status);
    }

    @Override
    public void markDelivered(int orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        order.setStatus(OrderStatus.DELIVERED);
        orderRepository.updateStatus(orderId, OrderStatus.DELIVERED);

        // notify observers (ORDER DELIVERED)
        notificationManager.notifyObservers(order);
    }
}


