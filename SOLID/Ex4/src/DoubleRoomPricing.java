public class DoubleRoomPricing implements RoomPricing {

    @Override
    public Money monthlyFee() {
        return new Money(15000.0);
    }
}