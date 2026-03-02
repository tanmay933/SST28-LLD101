public class StandardPricingPolicy implements PricingPolicy {

    @Override
    public double fare(double km) {
        double fare = 50.0 + km * 6.6666666667;
        return Math.round(fare * 100.0) / 100.0;
    }
}