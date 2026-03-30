package elevator.strategies.impl;

import java.util.List;

import elevator.models.Elevator;
import elevator.requests.Request;
import elevator.strategies.ElevatorSelectionStrategy;
import elevator.enums.ElevatorState;

public class NearestElevatorSelectionStrategy implements ElevatorSelectionStrategy {

    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {

        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {

            if (elevator.getState() == ElevatorState.MAINTENANCE) continue;

            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());

            if (distance < minDistance) {
                minDistance = distance;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }
}
