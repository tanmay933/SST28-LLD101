package parkinglot.strategy;

import parkinglot.model.*;

public interface SlotAllocationStrategy {
    ParkingSlot allocate(Vehicle v);
}