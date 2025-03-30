package behaviouraldesignPattern.StrategyPatternImplementation;

public class CreditCardStrategy implements PaymentStrategy{

    private String walletAddress;

    public CreditCardStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Credit Card strategy");
    }
}
