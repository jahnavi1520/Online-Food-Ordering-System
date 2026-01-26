package main.java.foodOrdering.Payment;

public class UpiPaymentStrategy implements PaymentStrategy {

    private final String upiId;

    public UpiPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(int orderId, double amount) {
        System.out.println("Paid ₹" + amount + " using UPI for Order " + orderId);
        System.out.println("Amount: ₹" + amount);
        System.out.println("UPI payment successful");
        return true;
    }
}
