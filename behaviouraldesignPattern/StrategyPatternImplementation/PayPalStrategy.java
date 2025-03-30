package behaviouraldesignPattern.StrategyPatternImplementation;

public class PayPalStrategy implements PaymentStrategy{

    private String walletAddress;

    public PayPalStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paypal strategy");
    }
}
