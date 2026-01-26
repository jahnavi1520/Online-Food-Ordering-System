package main.java.foodOrdering.repository;

import java.sql.Connection;

public class DatabaseRepositoryFactory implements RepositoryFactory {

    private final Connection connection;

    public DatabaseRepositoryFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public UserRepository getUserRepository() {
        return new DatabaseUserRepository(connection);
    }

    @Override
    public RestaurantRepository getRestaurantRepository() {
        return new DatabaseRestaurantRepository(connection);
    }

    @Override
    public CartRepository getCartRepository() {
        return new DatabaseCartRepository(connection);
    }

    @Override
    public OrderRepository getOrderRepository() {
        return new DatabaseOrderRepository(connection);
    }
}
