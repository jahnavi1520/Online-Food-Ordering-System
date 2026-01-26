package main.java.foodOrdering.Payment;

public class CardPaymentStrategy implements PaymentStrategy {

    private final String cardNumber;
    private final String holderName;

    public CardPaymentStrategy(String cardNumber, String holderName) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
    }

    @Override
    public boolean pay(int orderId, double amount) {
        System.out.println("Paid ₹" + amount + " using Card for Order " + orderId);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Card payment successful");
        return true;
    }
}
