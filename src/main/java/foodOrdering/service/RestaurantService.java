package main.java.foodOrdering.service;

import main.java.foodOrdering.model.Restaurant;
import main.java.foodOrdering.model.FoodItem;

import java.util.List;

public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(int id);

    List<FoodItem> getMenuByRestaurantId(int restaurantId);

    void addFoodItems(int restaurantId, List<FoodItem> foodItems);
}
