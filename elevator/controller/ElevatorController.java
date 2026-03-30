package elevator.controller;

import java.util.List;

import elevator.models.Elevator;
import elevator.requests.Request;
import elevator.strategies.ElevatorSelectionStrategy;
import elevator.strategies.SchedulingStrategy;

public class ElevatorController {

    private ElevatorSelectionStrategy selectionStrategy;
    private SchedulingStrategy schedulingStrategy;

    public ElevatorController(ElevatorSelectionStrategy selectionStrategy,
                              SchedulingStrategy schedulingStrategy) {
        this.selectionStrategy = selectionStrategy;
        this.schedulingStrategy = schedulingStrategy;
    }

    public void assignElevator(List<Elevator> elevators, Request request) {

        Elevator elevator = selectionStrategy.selectElevator(elevators, request);

        if (elevator == null) {
            System.out.println("No elevator available");
            return;
        }

        schedulingStrategy.schedule(elevator, request);
    }
}
