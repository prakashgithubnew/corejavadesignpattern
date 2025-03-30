package behaviouraldesignPattern.StrategyPatternImplementation;

public class DebitCardStrategy implements PaymentStrategy {

    private String walletAddress;

    public DebitCardStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {

        System.out.println("Debit Card strategy");
    }
}
