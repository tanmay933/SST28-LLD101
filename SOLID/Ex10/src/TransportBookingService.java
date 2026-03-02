public class TransportBookingService {

    private final DistanceService distanceService;
    private final DriverAllocationService driverService;
    private final PaymentService paymentService;
    private final PricingPolicy pricingPolicy;

    public TransportBookingService(
            DistanceService distanceService,
            DriverAllocationService driverService,
            PaymentService paymentService,
            PricingPolicy pricingPolicy) {

        this.distanceService = distanceService;
        this.driverService = driverService;
        this.paymentService = paymentService;
        this.pricingPolicy = pricingPolicy;
    }

    public void book(TripRequest req) {

        double km = distanceService.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverService.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = pricingPolicy.fare(km);

        String txn = paymentService.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}