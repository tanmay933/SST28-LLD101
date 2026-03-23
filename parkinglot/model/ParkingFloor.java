package parkinglot.model;

import java.util.List;

public class ParkingFloor {
    private int floorId;
    private List<ParkingSlot> slots;

    public ParkingFloor(int floorId, List<ParkingSlot> slots) {
        this.floorId = floorId;
        this.slots = slots;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}