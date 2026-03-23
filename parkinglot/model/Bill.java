package parkinglot.model;

import java.time.LocalDateTime;

public class Bill {
    private Ticket ticket;
    private LocalDateTime exitTime;
    private double amount;

    public Bill(Ticket ticket, LocalDateTime exitTime, double amount) {
        this.ticket = ticket;
        this.exitTime = exitTime;
        this.amount = amount;
    }

    public double getAmount() { return amount; }
}