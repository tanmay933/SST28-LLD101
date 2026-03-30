package bookmyshow.controller;

import bookmyshow.model.*;
import bookmyshow.service.BookingService;
import bookmyshow.strategy.payment.PaymentStrategy;

import java.util.List;

public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // book tickets
    public Booking bookTickets(User user, Show show, List<ShowSeat> seats, PaymentStrategy paymentStrategy) {
        return bookingService.createBooking(user, show, seats, paymentStrategy);
    }

    // cancel booking
    public void cancelBooking(Booking booking) {
        bookingService.cancelBooking(booking);
    }
}