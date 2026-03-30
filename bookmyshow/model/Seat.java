package bookmyshow.model;

import bookmyshow.model.enums.SeatType;

public class Seat {
    private String id;
    private int row;
    private int number;
    private SeatType type;

    public Seat(String id, int row, int number, SeatType type) {
        this.id = id;
        this.row = row;
        this.number = number;
        this.type = type;
    }

    public String getId() { return id; }
    public SeatType getType() { return type; }
}