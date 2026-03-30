package elevator.system;

import java.util.*;

import elevator.controller.ElevatorController;
import elevator.enums.Direction;
import elevator.models.Elevator;
import elevator.requests.ExternalRequest;
import elevator.requests.InternalRequest;
import elevator.requests.Request;

public class ElevatorSystem {

    private List<Elevator> elevators;
    private ElevatorController controller;

    public ElevatorSystem(int numOfElevators, ElevatorController controller) {
        this.elevators = new ArrayList<>();
        this.controller = controller;

        for (int i = 0; i < numOfElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    // External request (from floor)
    public void handleExternalRequest(int floor, Direction direction) {
        Request request = new ExternalRequest(floor, direction);
        controller.assignElevator(elevators, request);
    }

    // Internal request (inside elevator)
    public void handleInternalRequest(int elevatorId, int destinationFloor) {
        Request request = new InternalRequest(destinationFloor);
        elevators.get(elevatorId).addRequest(request);
    }
}
