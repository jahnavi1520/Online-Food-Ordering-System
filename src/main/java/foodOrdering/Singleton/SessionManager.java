package main.java.foodOrdering.Singleton;

import main.java.foodOrdering.model.User;

public class SessionManager {
    private static SessionManager instance;
    private User loggedInUser;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(User user) {
        this.loggedInUser = user;
    }

    public void logout() {
        this.loggedInUser = null;
    }

    public User getUser() {
        return loggedInUser;
    }
}

