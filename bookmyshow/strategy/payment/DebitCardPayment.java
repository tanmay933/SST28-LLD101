package bookmyshow.strategy.payment;

public class DebitCardPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid using Debit Card: " + amount);
        return true;
    }
}