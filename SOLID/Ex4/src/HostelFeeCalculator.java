import java.util.*;

public class HostelFeeCalculator {

    private final FakeBookingRepo repo;
    private final Map<Integer, RoomPricing> roomPricingMap;
    private final Map<AddOn, AddOnPricing> addOnPricingMap;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;

        // Room pricing wiring (Java 8 compatible)
        roomPricingMap = new HashMap<>();
        roomPricingMap.put(LegacyRoomTypes.SINGLE, new SingleRoomPricing());
        roomPricingMap.put(LegacyRoomTypes.DOUBLE, new DoubleRoomPricing());
        roomPricingMap.put(LegacyRoomTypes.TRIPLE, new TripleRoomPricing());
        roomPricingMap.put(LegacyRoomTypes.DELUXE, new DeluxeRoomPricing());

        // Add-on pricing wiring (Java 8 compatible)
        addOnPricingMap = new HashMap<>();
        addOnPricingMap.put(AddOn.MESS, new MessPricing());
        addOnPricingMap.put(AddOn.LAUNDRY, new LaundryPricing());
        addOnPricingMap.put(AddOn.GYM, new GymPricing());
    }

    public void process(BookingRequest req) {

        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {

        Money total = new Money(0.0);

        // Room contribution
        RoomPricing roomPricing = roomPricingMap.get(req.roomType);
        if (roomPricing == null) {
            throw new IllegalArgumentException("Unknown room type: " + req.roomType);
        }
        total = total.plus(roomPricing.monthlyFee());

        // Add-on contributions
        for (AddOn addOn : req.addOns) {
            AddOnPricing pricing = addOnPricingMap.get(addOn);
            if (pricing == null) {
                throw new IllegalArgumentException("Unknown add-on: " + addOn);
            }
            total = total.plus(pricing.monthlyFee());
        }

        return total;
    }
}