package elevator.models;

import elevator.enums.Direction;
import elevator.system.ElevatorSystem;

public class Floor {

    private int floorNumber;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void pressUp(ElevatorSystem system) {
        system.handleExternalRequest(floorNumber, Direction.UP);
    }

    public void pressDown(ElevatorSystem system) {
        system.handleExternalRequest(floorNumber, Direction.DOWN);
    }
}
