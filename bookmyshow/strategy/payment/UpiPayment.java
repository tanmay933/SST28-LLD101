package bookmyshow.strategy.payment;

public class UpiPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid using UPI: " + amount);
        return true;
    }
}