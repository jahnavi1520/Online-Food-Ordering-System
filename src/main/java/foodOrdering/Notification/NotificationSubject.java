package main.java.foodOrdering.Notification;

import main.java.foodOrdering.model.Order;

public interface NotificationSubject {
    void addObserver(NotificationObserver observer);
    void removeObserver(NotificationObserver observer);
    void notifyObservers(Order order);
}
