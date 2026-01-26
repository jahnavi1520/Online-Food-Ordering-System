package main.java.foodOrdering.Notification;

import main.java.foodOrdering.model.Order;
import main.java.foodOrdering.model.User;
import main.java.foodOrdering.service.UserService;

public class EmailNotification implements NotificationObserver {
    private final UserService userService;

    public EmailNotification(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void update(Order order) {
        User user = userService.getUserByUsername(order.getUsername());

        System.out.println(
                "Email sent to " + user.getEmail() +
                        ": Order " + order.getOrderId() +
                        " is " + order.getStatus()
        );
    }
}
