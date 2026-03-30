package bookmyshow.service;

import bookmyshow.strategy.payment.PaymentStrategy;

public class PaymentService {

    public boolean processPayment(double amount, PaymentStrategy strategy) {
        return strategy.pay(amount);
    }
}