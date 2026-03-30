package bookmyshow.model;

public class ShowSeat {
    private String id;
    private Seat seat;
    private boolean isBooked;
    private double price;

    public ShowSeat(String id, Seat seat, double price) {
        this.id = id;
        this.seat = seat;
        this.price = price;
        this.isBooked = false;
    }

    public boolean isBooked() { return isBooked; }
    public void book() { this.isBooked = true; }
    public void unbook() { this.isBooked = false; }

    public double getPrice() { return price; }
}