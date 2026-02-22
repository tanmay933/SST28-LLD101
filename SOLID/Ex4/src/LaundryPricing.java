public class LaundryPricing implements AddOnPricing {
    public Money monthlyFee() {
        return new Money(500.0);
    }
}