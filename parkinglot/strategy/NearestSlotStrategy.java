package parkinglot.strategy;

import parkinglot.model.*;
import parkinglot.enums.*;
import java.util.*;

public class NearestSlotStrategy implements SlotAllocationStrategy {

    private List<ParkingSlot> slots;

    public NearestSlotStrategy(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    @Override
    public ParkingSlot allocate(Vehicle v) {
        List<SlotType> allowed = getAllowed(v.getType());

        return slots.stream()
                .filter(s -> s.isAvailable() && allowed.contains(s.getType()))
                .min(Comparator.comparingInt(ParkingSlot::getDistanceFromGate))
                .orElse(null);
    }

    private List<SlotType> getAllowed(VehicleType type) {
        if (type == VehicleType.BIKE)
            return Arrays.asList(SlotType.SMALL, SlotType.MEDIUM, SlotType.LARGE);
        if (type == VehicleType.CAR)
            return Arrays.asList(SlotType.MEDIUM, SlotType.LARGE);
        return Arrays.asList(SlotType.LARGE);
    }
}