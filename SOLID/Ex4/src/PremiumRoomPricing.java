public class PremiumRoomPricing implements RoomPricing {
    public Money monthlyFee() {
        return new Money(20000.0);
    }
}