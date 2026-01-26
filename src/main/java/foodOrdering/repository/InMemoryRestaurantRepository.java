package main.java.foodOrdering.repository;

import main.java.foodOrdering.model.FoodItem;
import main.java.foodOrdering.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRestaurantRepository implements RestaurantRepository {

    private final Map<Integer, Restaurant> restaurants = new HashMap<>();
    private int idCounter = 1;
    private int foodItemIdCounter = 1;


    public void save(Restaurant restaurant) {
        if (restaurant.getId() == 0) {
            restaurant.setId(idCounter++);
        }
        restaurants.put(restaurant.getId(), restaurant);
    }

    public Restaurant findById(int id) {
        return restaurants.get(id);
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurants.values());
    }

    public List<FoodItem> findMenuByRestaurantId(int restaurantId) {
        Restaurant r = restaurants.get(restaurantId);
        return r != null ? r.getMenu() : List.of();
    }

    public void saveFoodItem(int restaurantId, FoodItem foodItem) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant not found");
        }

        foodItem.setId(foodItemIdCounter++);
        restaurant.getMenu().add(foodItem);
    }

}
