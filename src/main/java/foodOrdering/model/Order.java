package main.java.foodOrdering.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
        private int orderId;
        private String username;
        private List<CartItem> items;
        private LocalDateTime date;
        private double total;
        private OrderStatus status;

        public Order(int orderId, String username, double total) {
            this.orderId = orderId;
            this.username = username;
            this.items = new ArrayList<>();
            this.total = total;
            this.date = LocalDateTime.now();
            this.status = OrderStatus.PLACED;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
            this.status = status;
        }
    }

