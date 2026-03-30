package elevator.models;

import java.util.*;

import elevator.enums.Direction;
import elevator.enums.ElevatorState;
import elevator.requests.Request;

public class Elevator {

    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private int currentLoad;

    private List<Request> requests;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.requests = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void move() {
        if (requests.isEmpty()) {
            state = ElevatorState.IDLE;
            direction = Direction.IDLE;
            return;
        }

        state = ElevatorState.MOVING;

        while (!requests.isEmpty()) {
            Request req = requests.remove(0);

            if (req.getFloor() > currentFloor) {
                direction = Direction.UP;
            } else if (req.getFloor() < currentFloor) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.IDLE;
            }

            System.out.println("Elevator " + id + " moving from "
                    + currentFloor + " to " + req.getFloor());

            currentFloor = req.getFloor();
        }

        state = ElevatorState.IDLE;
        direction = Direction.IDLE;
    }
}
