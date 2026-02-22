import java.util.List;

public class Invoice {
    public final String id;
    public final List<InvoiceLine> lines;
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public Invoice(String id,
                   List<InvoiceLine> lines,
                   double subtotal,
                   double taxPct,
                   double tax,
                   double discount,
                   double total) {

        this.id = id;
        this.lines = lines;
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}