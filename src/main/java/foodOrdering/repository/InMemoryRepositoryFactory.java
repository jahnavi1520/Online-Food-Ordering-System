package main.java.foodOrdering.repository;

public class InMemoryRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository getUserRepository() {
        return new InMemoryUserRepository();
    }

    @Override
    public RestaurantRepository getRestaurantRepository() {
        return new InMemoryRestaurantRepository();
    }

    @Override
    public CartRepository getCartRepository() {
        return new InMemoryCartRepository();
    }

    @Override
    public OrderRepository getOrderRepository() {
        return new InMemoryOrderRepository();
    }
}
