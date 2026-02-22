public class TripleRoomPricing implements RoomPricing {

    @Override
    public Money monthlyFee() {
        return new Money(12000.0);
    }
}