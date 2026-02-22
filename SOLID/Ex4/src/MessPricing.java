public class MessPricing implements AddOnPricing {
    public Money monthlyFee() {
        return new Money(1000.0);
    }
}