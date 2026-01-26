package main.java.foodOrdering.Notification;

import main.java.foodOrdering.model.Order;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements NotificationSubject {

    private static NotificationManager instance;
    private final List<NotificationObserver> observers = new ArrayList<>();

    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    @Override
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Order order) {
        for (NotificationObserver observer : observers) {
            observer.update(order);
        }
    }
}

