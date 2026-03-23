package pen;

public class Pen {
    private PenState state;
    private Refill refill;
    private Nib nib;

    public Pen(Refill refill, Nib nib) {
        this.refill = refill;
        this.nib = nib;
        this.state = PenState.CLOSED;
    }

    public void start() {
        if (state == PenState.OPEN) {
            System.out.println("Pen already open");
            return;
        }
        state = PenState.OPEN;
        System.out.println("Pen opened");
    }

    public void write(String text) {
        if (state != PenState.OPEN) {
            System.out.println("Open pen first");
            return;
        }

        int inkNeeded = text.length();

        if (!refill.hasInk(inkNeeded)) {
            System.out.println("Not enough ink");
            return;
        }

        refill.consume(inkNeeded);
        System.out.println("Writing: " + text + " [" 
            + refill.getInk().getColor() + ", " 
            + nib.getType() + "]");
    }

    public void close() {
        if (state == PenState.CLOSED) {
            System.out.println("Pen already closed");
            return;
        }
        state = PenState.CLOSED;
        System.out.println("Pen closed");
    }

    public void refill(int amount) {
        refill.refill(amount);
        System.out.println("Refilled. Current ink: " + refill.getLevel());
    }
}