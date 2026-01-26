package main.java.foodOrdering.repository;

import java.sql.Connection;

public class RepositoryFactoryProvider {
    public static RepositoryFactory getFactory(
            RepositoryType type, Connection connection) {

        if (type == RepositoryType.IN_MEMORY) {
            return new InMemoryRepositoryFactory();
        }
        if (type == RepositoryType.DATABASE) {
            return new DatabaseRepositoryFactory(connection);
        }
        throw new RuntimeException("Invalid repository type");
    }
}
