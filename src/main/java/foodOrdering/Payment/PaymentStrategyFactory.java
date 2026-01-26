package main.java.foodOrdering.Payment;

public class PaymentStrategyFactory {
    private PaymentStrategyFactory() {}

    public static PaymentStrategy createCardPayment(String cardNumber, String holderName) {
        return new CardPaymentStrategy(cardNumber, holderName);
    }

    public static PaymentStrategy createUpiPayment(String upiId) {
        return new UpiPaymentStrategy(upiId);
    }

    public static PaymentStrategy createCashOnDelivery() {
        return new CashOnDelivery();
    }
}

