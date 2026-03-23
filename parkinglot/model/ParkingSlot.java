package parkinglot.model;

import parkinglot.enums.*;

public class ParkingSlot {
    private String id;
    private SlotType type;
    private SlotStatus status;
    private int distanceFromGate;

    public ParkingSlot(String id, SlotType type, int distanceFromGate) {
        this.id = id;
        this.type = type;
        this.distanceFromGate = distanceFromGate;
        this.status = SlotStatus.FREE;
    }

    public boolean isAvailable() {
        return status == SlotStatus.FREE;
    }

    public void occupy() { status = SlotStatus.OCCUPIED; }
    public void free() { status = SlotStatus.FREE; }

    public SlotType getType() { return type; }
    public int getDistanceFromGate() { return distanceFromGate; }
}