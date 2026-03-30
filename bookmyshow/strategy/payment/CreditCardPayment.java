package bookmyshow.strategy.payment;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid using Credit Card: " + amount);
        return true;
    }
}