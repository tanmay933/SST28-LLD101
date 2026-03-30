package bookmyshow.service;

import bookmyshow.model.*;
import bookmyshow.strategy.payment.PaymentStrategy;
import bookmyshow.strategy.pricing.PricingStrategy;

import java.util.List;

public class BookingService {

    private SeatAllocationService seatService;
    private PaymentService paymentService;
    private PricingStrategy pricingStrategy;

    public BookingService(SeatAllocationService seatService,
            PaymentService paymentService,
            PricingStrategy pricingStrategy) {
        this.seatService = seatService;
        this.paymentService = paymentService;
        this.pricingStrategy = pricingStrategy;
    }

    public void cancelBooking(Booking booking) {
        booking.cancel();
        seatService.releaseSeats(booking.getSeats());
    }

    public Booking createBooking(User user, Show show, List<ShowSeat> seats, PaymentStrategy paymentStrategy) {

        boolean locked = seatService.lockSeats(seats);
        if (!locked) {
            throw new RuntimeException("Seats already booked");
        }

        Booking booking = new Booking("B1", user, show, seats);

        double total = 0;
        for (ShowSeat seat : seats) {
            total += pricingStrategy.calculatePrice(seat);
        }

        boolean paymentSuccess = paymentService.processPayment(total, paymentStrategy);

        if (paymentSuccess) {
            booking.confirm();
        } else {
            seatService.releaseSeats(seats);
            booking.cancel();
        }

        return booking;
    }
}