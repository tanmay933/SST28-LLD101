package bookmyshow.repository;

import bookmyshow.model.Booking;
import java.util.*;

public class BookingRepository {

    private Map<String, Booking> bookings = new HashMap<>();

    public void save(Booking booking) {
        bookings.put(booking.toString(), booking);
    }

    public Booking get(String id) {
        return bookings.get(id);
    }
}