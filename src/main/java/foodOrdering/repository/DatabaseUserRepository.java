package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.User;
import java.sql.*;


public class DatabaseUserRepository implements UserRepository {

    private final Connection connection;

    public DatabaseUserRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO users(username, password, role, name, email, phone_number, address) VALUES (?,?,?,?,?,?,?)"
            );
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhoneNumber());
            ps.setString(7, user.getAddress());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findByUsername(String username) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM users WHERE username=?"
            );
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean existsByUsername(String username) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT COUNT(*) FROM users WHERE username = ?"
            );
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            rs.next();

            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to check username existence", e);
        }
    }
}

