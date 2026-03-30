package elevator.strategies;

import elevator.models.Elevator;
import elevator.requests.Request;

public interface SchedulingStrategy {

    void schedule(Elevator elevator, Request request);
}
