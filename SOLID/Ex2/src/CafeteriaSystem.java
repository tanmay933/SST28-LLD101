import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;

    private final InvoiceRepository repository;
    private final PricingCalculator pricing = new PricingCalculator();
    private final TaxPolicy taxPolicy = new DefaultTaxPolicy();
    private final DiscountPolicy discountPolicy = new DefaultDiscountPolicy();
    private final InvoiceFormatter formatter = new InvoiceFormatter();

    public CafeteriaSystem(InvoiceRepository repository) {
        this.repository = repository;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        // Build invoice lines + calculate subtotal
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;

            invoiceLines.add(
                    new InvoiceLine(item.name, l.qty, lineTotal)
            );
        }

        // Tax + discount
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountPolicy
                .discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        // Create invoice object
        Invoice invoice = new Invoice(
                invId,
                invoiceLines,
                subtotal,
                taxPct,
                tax,
                discount,
                total
        );

        // Format invoice
        String printable = formatter.format(invoice);

        // Print
        System.out.print(printable);

        // Persist via abstraction
        repository.save(invId, printable);

        System.out.println("Saved invoice: " + invId +
                " (lines=" + repository.countLines(invId) + ")");
    }
}