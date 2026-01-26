package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.FoodItem;
import main.java.foodOrdering.model.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class DatabaseRestaurantRepository implements RestaurantRepository {

    private final Connection connection;

    public DatabaseRestaurantRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Restaurant restaurant) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO restaurants (name, location, open) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getLocation());
            ps.setBoolean(3, restaurant.isOpen());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                restaurant.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Restaurant findById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM restaurants WHERE id=?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getBoolean("open"),
                        List.of()
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Restaurant> findAll() {
        List<Restaurant> list = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement()
                    .executeQuery("SELECT * FROM restaurants");

            while (rs.next()) {
                list.add(new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getBoolean("open"),
                        List.of()
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<FoodItem> findMenuByRestaurantId(int restaurantId) {
        List<FoodItem> menu = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM food_item WHERE restaurant_id = ?"
            );
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                menu.add(new FoodItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getBoolean("veg"),
                        rs.getBoolean("available")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menu;
    }

    public void saveFoodItem(int restaurantId, FoodItem foodItem) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO food_item (restaurant_id, name, price, veg, available) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, restaurantId);
            ps.setString(2, foodItem.getName());
            ps.setDouble(3, foodItem.getPrice());
            ps.setBoolean(4, foodItem.isVeg());
            ps.setBoolean(5, foodItem.isAvailable());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                foodItem.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save food item", e);
        }
    }
}

