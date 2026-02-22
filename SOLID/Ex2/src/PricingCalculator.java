import java.util.List;
import java.util.Map;

public class PricingCalculator {
    public double calculateSubtotal(Map<String, MenuItem> menu,
                                     List<OrderLine> lines) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }
        return subtotal;
    }
}