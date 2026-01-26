package main.java.foodOrdering.service;

import main.java.foodOrdering.model.User;
import main.java.foodOrdering.repository.UserRepository;
import main.java.foodOrdering.service.UserService;

public class UserServiceImpl  implements UserService{
    private final UserRepository userRepository;
    private User currentUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        seedAdminUser();
    }

    // 🔐 Hardcoded Admin
    private void seedAdminUser() {
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User(
                    "admin",
                    "admin123",
                    "ADMIN",
                    "Admin",
                    "admin@food.com",
                    "9999999999",
                    "HQ"
            );
            userRepository.save(admin);
        }
    }

    @Override
    public boolean register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return user;
        }
        return null;
    }

    @Override
    public void logout() {
        currentUser = null;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
