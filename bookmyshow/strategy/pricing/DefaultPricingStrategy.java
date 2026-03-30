package bookmyshow.strategy.pricing;

import bookmyshow.model.ShowSeat;

public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(ShowSeat seat) {
        return seat.getPrice(); // base price
    }
}