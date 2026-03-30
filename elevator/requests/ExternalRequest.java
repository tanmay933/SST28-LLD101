package elevator.requests;

import elevator.enums.Direction;

public class ExternalRequest extends Request {

    private Direction direction;

    public ExternalRequest(int floor, Direction direction) {
        super(floor);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
