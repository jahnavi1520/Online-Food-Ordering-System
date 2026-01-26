package main.java.foodOrdering.service;

import main.java.foodOrdering.model.User;

public interface UserService {
    boolean register(User user);

    User login(String username, String password);

    void logout();

    User getCurrentUser();

    User getUserByUsername(String username);

}
