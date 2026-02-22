public class DeluxeRoomPricing implements RoomPricing {

    @Override
    public Money monthlyFee() {
        return new Money(16000.0);
    }
}