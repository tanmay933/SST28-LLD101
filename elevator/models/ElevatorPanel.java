package elevator.models;

import elevator.requests.InternalRequest;

public class ElevatorPanel {

    private Elevator elevator;

    public ElevatorPanel(Elevator elevator) {
        this.elevator = elevator;
    }

    public void selectFloor(int floor) {
        elevator.addRequest(new InternalRequest(floor));
    }
}