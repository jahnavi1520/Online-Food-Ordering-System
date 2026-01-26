package main.java.foodOrdering.repository;

public interface RepositoryFactory {
    UserRepository getUserRepository();

    RestaurantRepository getRestaurantRepository();

    CartRepository getCartRepository();

    OrderRepository getOrderRepository();
}
