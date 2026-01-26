package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.User;

public interface UserRepository {
    void save(User user);

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
