package parkinglot.model;

import java.time.LocalDateTime;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;

    public Ticket(String id, Vehicle v, ParkingSlot s, LocalDateTime t) {
        this.id = id;
        this.vehicle = v;
        this.slot = s;
        this.entryTime = t;
    }

    public ParkingSlot getSlot() { return slot; }
    public LocalDateTime getEntryTime() { return entryTime; }
}