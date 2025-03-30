package behaviouraldesignPattern.StrategyPatternImplementation;

// StrategyPatternExample.java
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardStrategy("1234-5678-9876-5432"));
        context.executePayment(100);

        // Pay using PayPal
        context.setPaymentStrategy(new PayPalStrategy("user@example.com"));
        context.executePayment(200);

        // Pay using Bitcoin
        context.setPaymentStrategy(new DebitCardStrategy("1BitcoinAddress12345"));
        context.executePayment(300);
    }
}
