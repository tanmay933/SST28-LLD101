package parkinglot;

import parkinglot.model.*;
import parkinglot.enums.*;
import parkinglot.service.*;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<ParkingSlot> slots = Arrays.asList(
                new ParkingSlot("S1", SlotType.SMALL, 5),
                new ParkingSlot("M1", SlotType.MEDIUM, 3),
                new ParkingSlot("L1", SlotType.LARGE, 1)
        );

        ParkingService service = new ParkingService(slots);

        Vehicle bike = new Vehicle("B1", VehicleType.BIKE);

        Ticket t = service.park(bike, LocalDateTime.now());

        service.status();

        double bill = service.exit(t, LocalDateTime.now().plusHours(2));

        System.out.println("Bill: " + bill);
    }
}