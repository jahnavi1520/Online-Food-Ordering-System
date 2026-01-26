package main.java.foodOrdering.service;

import main.java.foodOrdering.model.Cart;
import main.java.foodOrdering.model.FoodItem;

public interface CartService {
    void addItem(String username, FoodItem item);

    void removeItem(String username, FoodItem item);

    void increaseQuantity(String username, FoodItem item);

    void decreaseQuantity(String username, FoodItem item);

    Cart getCart(String username);

    double getTotalAmount(String username);

    void clearCart(String username);
}
