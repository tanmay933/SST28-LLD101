package parkinglot.service;

import parkinglot.model.*;
import parkinglot.enums.*;
import java.time.*;
import java.util.*;

public class BillingService {

    private Map<SlotType, Integer> rates = new HashMap<>();

    public BillingService() {
        rates.put(SlotType.SMALL, 10);
        rates.put(SlotType.MEDIUM, 20);
        rates.put(SlotType.LARGE, 30);
    }

    public double calculate(Ticket t, LocalDateTime exit) {
        long hours = Math.max(1,
                Duration.between(t.getEntryTime(), exit).toHours());

        return hours * rates.get(t.getSlot().getType());
    }
}