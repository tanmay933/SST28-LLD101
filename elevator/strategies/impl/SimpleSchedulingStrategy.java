package elevator.strategies.impl;

import elevator.models.Elevator;
import elevator.requests.Request;
import elevator.strategies.SchedulingStrategy;

public class SimpleSchedulingStrategy implements SchedulingStrategy {

    @Override
    public void schedule(Elevator elevator, Request request) {
        elevator.addRequest(request);
    }
}
