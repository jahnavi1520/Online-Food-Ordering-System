package main.java.foodOrdering.Payment;

public class CashOnDelivery  implements PaymentStrategy {

    @Override
    public boolean pay(int orderId, double amount) {
        System.out.println("Cash on Delivery selected for Order " + orderId);
        System.out.println("Amount to pay: ₹" + amount);
        return true;
    }
}
