package main.java.foodOrdering.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<CartItem> items = new ArrayList<>();

    public void addItem(FoodItem foodItem) {
        for (CartItem ci : items) {
            if (ci.getItem().getId() == foodItem.getId()) {
                ci.increase();
                return;
            }
        }
        items.add(new CartItem(foodItem));
    }

    public void decreaseItem(FoodItem foodItem) {
        items.removeIf(ci -> {
            if (ci.getItem().getId() == foodItem.getId()) {
                ci.decrease();
                return ci.getQuantity() == 0;
            }
            return false;
        });
    }

    public void removeItem(FoodItem foodItem) {
        items.removeIf(cartItem -> cartItem.getItem().getId() == foodItem.getId());
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(CartItem::getSubTotal)
                .sum();
    }

    public void clear() {
        items.clear();
    }

}
