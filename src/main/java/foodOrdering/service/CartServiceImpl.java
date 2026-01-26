package main.java.foodOrdering.service;

import main.java.foodOrdering.model.Cart;
import main.java.foodOrdering.model.CartItem;
import main.java.foodOrdering.model.FoodItem;
import main.java.foodOrdering.repository.CartRepository;
import main.java.foodOrdering.service.CartService;

public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void addItem(String username, FoodItem item) {
        Cart cart = getOrCreateCart(username); // cart {33, john}
        cart.addItem(item); // cart {[33,34], john}
        cartRepository.saveCart(username, cart);
    }

    @Override
    public void removeItem(String username, FoodItem item) {
        Cart cart = getOrCreateCart(username);
        cart.removeItem(item);
        cartRepository.saveCart(username, cart);
    }

    @Override
    public void increaseQuantity(String username, FoodItem item) {
        addItem(username, item);
    }

    @Override
    public void decreaseQuantity(String username, FoodItem item) {
        Cart cart = getOrCreateCart(username);
        cart.decreaseItem(item);
        cartRepository.saveCart(username, cart);
    }

    @Override
    public Cart getCart(String username) {
        return getOrCreateCart(username);
    }

    @Override
    public double getTotalAmount(String username) {
        return getOrCreateCart(username).getTotal();
    }

    @Override
    public void clearCart(String username) {
        cartRepository.clearCart(username);
    }

    private Cart getOrCreateCart(String username) {
        Cart cart = cartRepository.getCart(username);
        if (cart == null) {
            cart = new Cart();
            cartRepository.saveCart(username, cart);
        }
        return cart;
    }
}
