package main.java.foodOrdering.repository;


import main.java.foodOrdering.model.FoodItem;
import main.java.foodOrdering.model.Restaurant;
import java.util.List;

public interface RestaurantRepository {
    void save(Restaurant restaurant);
    Restaurant findById(int id);
    List<Restaurant> findAll();
    List<FoodItem> findMenuByRestaurantId(int restaurantId);
    void saveFoodItem(int restaurantId, FoodItem foodItem);
}
