public class InvoiceLine {
    public final String name;
    public final int qty;
    public final double lineTotal;

    public InvoiceLine(String name, int qty, double lineTotal) {
        this.name = name;
        this.qty = qty;
        this.lineTotal = lineTotal;
    }
}