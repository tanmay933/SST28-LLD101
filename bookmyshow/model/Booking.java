package bookmyshow.model;

import java.util.List;
import bookmyshow.model.enums.BookingStatus;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<ShowSeat> seats;
    private BookingStatus status;

    public Booking(String id, User user, Show show, List<ShowSeat> seats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.CREATED;
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = BookingStatus.CANCELLED;
    }

    public List<ShowSeat> getSeats() { return seats; }
}