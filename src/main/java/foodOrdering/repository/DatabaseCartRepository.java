package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.Cart;
import main.java.foodOrdering.model.CartItem;
import main.java.foodOrdering.model.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseCartRepository implements CartRepository {

    private final Connection connection;

    public DatabaseCartRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cart getCart(String username) {
        Cart cart = new Cart();
        boolean hasItems = false;

        String sql = """
        SELECT fi.id, fi.name, fi.price, fi.veg, fi.available, ci.quantity
        FROM cart_item ci
        JOIN food_item fi ON ci.food_item_id = fi.id
        WHERE ci.username = ?
    """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hasItems = true;

                FoodItem foodItem = new FoodItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getBoolean("veg"),
                        rs.getBoolean("available")
                );

                int quantity = rs.getInt("quantity");
                for (int i = 0; i < quantity; i++) {
                    cart.addItem(foodItem);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load cart", e);
        }

        return hasItems ? cart : null;
    }



    public void saveCart(String username, Cart cart) {

        String insertSql = """
                    INSERT INTO cart_item (username, food_item_id, quantity)
                    VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE quantity = ?
                """;

        try {
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                for (CartItem item : cart.getItems()) {
                    ps.setString(1, username);
                    ps.setLong(2, item.getItem().getId());
                    ps.setInt(3, item.getQuantity());
                    ps.setInt(4, item.getQuantity());
                    ps.addBatch();
                }
                ps.executeBatch();
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to save cart", e);
        }
    }

    @Override
    public void clearCart(String username) {
        try (PreparedStatement ps =
                     connection.prepareStatement("DELETE FROM cart_item WHERE username = ?")) {
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear cart", e);
        }
    }
}

