package parkinglot.repository;

import parkinglot.model.ParkingSlot;
import java.util.*;

public class SlotRepository {
    private List<ParkingSlot> slots;

    public SlotRepository(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public List<ParkingSlot> getAll() { return slots; }
}