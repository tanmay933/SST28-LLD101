package bookmyshow.model;

import bookmyshow.model.enums.PaymentMode;
import bookmyshow.model.enums.PaymentStatus;

public class Payment {
    private String id;
    private double amount;
    private PaymentMode mode;
    private PaymentStatus status;

    public Payment(String id, double amount, PaymentMode mode) {
        this.id = id;
        this.amount = amount;
        this.mode = mode;
        this.status = PaymentStatus.PENDING;
    }

    public void markSuccess() { this.status = PaymentStatus.SUCCESS; }
    public void markFailed() { this.status = PaymentStatus.FAILED; }
}