package main.java.foodOrdering.Notification;

import main.java.foodOrdering.model.Order;

public interface NotificationObserver {
    void update(Order order);
}
