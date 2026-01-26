package main.java.foodOrdering.Notification;

import main.java.foodOrdering.model.Order;
import main.java.foodOrdering.model.User;
import main.java.foodOrdering.service.UserService;

public class SMSNotification implements NotificationObserver {

    private final UserService userService;

    public SMSNotification(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void update(Order order) {
        User user = userService.getUserByUsername(order.getUsername());

        System.out.println(
                "SMS sent to " + user.getPhoneNumber() +
                        ": Order " + order.getOrderId() +
                        " is " + order.getStatus()
        );
    }
}
