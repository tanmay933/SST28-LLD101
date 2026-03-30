package bookmyshow;

import bookmyshow.model.*;
import bookmyshow.model.enums.SeatType;
import bookmyshow.service.*;
import bookmyshow.strategy.payment.*;
import bookmyshow.strategy.pricing.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        SeatAllocationService seatService = new SeatAllocationService();
        PaymentService paymentService = new PaymentService();
        PricingStrategy pricingStrategy = new DefaultPricingStrategy();

        BookingService bookingService =
                new BookingService(seatService, paymentService, pricingStrategy);

        MovieService movieService = new MovieService();
        TheatreService theatreService = new TheatreService();
        ShowService showService = new ShowService();

        Movie movie = new Movie("M1", "Inception", 150);
        movieService.addMovie("Bangalore", movie);

        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("S1", 1, 1, SeatType.GOLD));
        seats.add(new Seat("S2", 1, 2, SeatType.GOLD));
        seats.add(new Seat("S3", 1, 3, SeatType.PLATINUM));

        Screen screen = new Screen("SC1", "Screen1", seats);

        Theatre theatre = new Theatre("T1", "PVR", "Bangalore", List.of(screen));
        theatreService.addTheatre("Bangalore", theatre);

        List<ShowSeat> showSeats = new ArrayList<>();
        for (Seat seat : seats) {
            showSeats.add(new ShowSeat(UUID.randomUUID().toString(), seat, 200));
        }

        Show show = new Show("SH1", movie, screen, System.currentTimeMillis(), showSeats);
        showService.addShow(show);

        User user = new User("U1", "Tanmay");

        List<ShowSeat> selectedSeats = Arrays.asList(showSeats.get(0), showSeats.get(1));

        PaymentStrategy paymentStrategy = new UpiPayment();

        Booking booking = bookingService.createBooking(user, show, selectedSeats, paymentStrategy);

        System.out.println("Booking status: " + booking);

        bookingService.cancelBooking(booking);

        System.out.println("Booking cancelled");
    }
}