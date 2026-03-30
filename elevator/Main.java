package elevator;

import elevator.controller.ElevatorController;
import elevator.enums.Direction;
import elevator.strategies.impl.NearestElevatorSelectionStrategy;
import elevator.strategies.impl.SimpleSchedulingStrategy;
import elevator.system.ElevatorSystem;
import elevator.models.Floor;

public class Main {

    public static void main(String[] args) {

        ElevatorController controller = new ElevatorController(
                new NearestElevatorSelectionStrategy(),
                new SimpleSchedulingStrategy()
        );

        ElevatorSystem system = new ElevatorSystem(2, controller);

        Floor floor0 = new Floor(0);
        Floor floor5 = new Floor(5);

        // External Requests
        floor0.pressUp(system);
        floor5.pressDown(system);

        // Internal Request
        system.handleInternalRequest(0, 7);

        // Move elevators
        system.getElevators().forEach(e -> e.move());
    }
}
