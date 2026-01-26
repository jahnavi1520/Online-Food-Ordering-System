package main.java.foodOrdering.Payment;

public interface PaymentStrategy {
    boolean pay(int orderId, double amount);
}
