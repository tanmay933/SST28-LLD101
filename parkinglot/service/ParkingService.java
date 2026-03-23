package parkinglot.service;

import parkinglot.model.*;
import parkinglot.repository.*;
import parkinglot.strategy.*;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingService {

    private SlotRepository slotRepo;
    private TicketRepository ticketRepo;
    private BillingService billingService;
    private SlotAllocationStrategy strategy;

    public ParkingService(List<ParkingSlot> slots) {
        this.slotRepo = new SlotRepository(slots);
        this.ticketRepo = new TicketRepository();
        this.billingService = new BillingService();
        this.strategy = new NearestSlotStrategy(slots);
    }

    public Ticket park(Vehicle v, LocalDateTime time) {
        ParkingSlot slot = strategy.allocate(v);

        if (slot == null) {
            System.out.println("No slot available");
            return null;
        }

        slot.occupy();

        String id = UUID.randomUUID().toString();
        Ticket t = new Ticket(id, v, slot, time);
        ticketRepo.save(id, t);

        return t;
    }

    public double exit(Ticket t, LocalDateTime exitTime) {
        double amount = billingService.calculate(t, exitTime);
        t.getSlot().free();
        return amount;
    }

    public void status() {
        Map<String, Integer> map = new HashMap<>();

        for (ParkingSlot s : slotRepo.getAll()) {
            if (s.isAvailable()) {
                map.put(s.getType().name(),
                        map.getOrDefault(s.getType().name(), 0) + 1);
            }
        }

        System.out.println(map);
    }
}