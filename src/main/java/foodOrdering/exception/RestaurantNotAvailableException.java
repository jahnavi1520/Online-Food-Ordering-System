package main.java.foodOrdering.exception;

public class RestaurantNotAvailableException extends RuntimeException {

    public RestaurantNotAvailableException(String message) {
        super(message);
    }
}
