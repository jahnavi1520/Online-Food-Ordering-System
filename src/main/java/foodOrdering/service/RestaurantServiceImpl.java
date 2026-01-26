package main.java.foodOrdering.service;

import main.java.foodOrdering.exception.RestaurantNotAvailableException;
import main.java.foodOrdering.model.FoodItem;
import main.java.foodOrdering.model.Restaurant;
import main.java.foodOrdering.repository.RestaurantRepository;
import main.java.foodOrdering.service.RestaurantService;

import java.util.Collections;

import java.util.List;

public class RestaurantServiceImpl  implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<FoodItem> getMenuByRestaurantId(int restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId);

        if (restaurant == null) {
            throw new RestaurantNotAvailableException("Restaurant not found");
        }

        if (!restaurant.isOpen()) {
            throw new RestaurantNotAvailableException("Restaurant is currently closed");
        }

        return restaurant.getMenu();
    }

    @Override
    public void addFoodItems(int restaurantId, List<FoodItem> foodItems) {
        for (FoodItem foodItem : foodItems) {
            restaurantRepository.saveFoodItem(restaurantId, foodItem);
        }
    }
}