package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.Cart;

public interface CartRepository {
    Cart getCart(String username);
    void saveCart(String username, Cart cart);
    void clearCart(String username);
}
