package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.OrderStatus;
import main.java.foodOrdering.model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderRepository implements OrderRepository {

    private final Connection connection;

    public DatabaseOrderRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Order order) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO orders (order_id, username, total, status) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setInt(1, order.getOrderId());
            ps.setString(2, order.getUsername());
            ps.setDouble(3, order.getTotal());
            ps.setString(4, order.getStatus().name());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save order", e);
        }
    }

    public Order findByOrderId(int orderId) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM orders WHERE order_id = ?"
            );
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Order order = new Order(
                        rs.getInt("order_id"),
                        rs.getString("username"),
                        rs.getDouble("total")
                );
                order.setStatus(OrderStatus.valueOf(rs.getString("status")));
                return order;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findByUsername(String username) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM orders WHERE username = ?"
            );
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("order_id"),
                        rs.getString("username"),
                        rs.getDouble("total")
                );
                order.setStatus(OrderStatus.valueOf(rs.getString("status")));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public void updateStatus(int orderId, OrderStatus status) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE orders SET status = ? WHERE order_id = ?"
            );
            ps.setString(1, status.name());
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

