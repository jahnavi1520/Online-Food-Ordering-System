package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.Cart;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCartRepository implements CartRepository{
    private final Map<String, Cart> carts = new HashMap<>();

    public Cart getCart(String username) {
        return carts.computeIfAbsent(username, k -> new Cart());
    }

    public void saveCart(String username, Cart cart) {
        carts.put(username, cart);
    }

    public void clearCart(String username) {
        carts.remove(username);
    }
}
