package elevator.requests;

public class InternalRequest extends Request {

    private int destinationFloor;

    public InternalRequest(int destinationFloor) {
        super(destinationFloor);
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
