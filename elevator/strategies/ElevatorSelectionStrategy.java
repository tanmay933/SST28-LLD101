package elevator.strategies;

import java.util.List;
import elevator.models.Elevator;
import elevator.requests.Request;

public interface ElevatorSelectionStrategy {

    Elevator selectElevator(List<Elevator> elevators, Request request);
}
