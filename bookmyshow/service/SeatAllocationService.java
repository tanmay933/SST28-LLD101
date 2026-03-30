package bookmyshow.service;

import bookmyshow.model.ShowSeat;
import java.util.List;

public class SeatAllocationService {

    public synchronized boolean lockSeats(List<ShowSeat> seats) {
        for (ShowSeat seat : seats) {
            if (seat.isBooked()) return false;
        }

        for (ShowSeat seat : seats) {
            seat.book();
        }
        return true;
    }

    public void releaseSeats(List<ShowSeat> seats) {
        for (ShowSeat seat : seats) {
            seat.unbook();
        }
    }
}