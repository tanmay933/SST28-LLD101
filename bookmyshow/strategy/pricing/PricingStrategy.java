package bookmyshow.strategy.pricing;

import bookmyshow.model.ShowSeat;

public interface PricingStrategy {
    double calculatePrice(ShowSeat seat);
}