public class SingleRoomPricing implements RoomPricing {

    @Override
    public Money monthlyFee() {
        return new Money(14000.0);
    }
}