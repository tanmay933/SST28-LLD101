package bookmyshow.strategy.pricing;

import bookmyshow.model.ShowSeat;

public class SurgePricingStrategy implements PricingStrategy {

    private double multiplier;

    public SurgePricingStrategy(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public double calculatePrice(ShowSeat seat) {
        return seat.getPrice() * multiplier;
    }
}