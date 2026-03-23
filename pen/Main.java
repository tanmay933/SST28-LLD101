package pen;

import pen.ink.*;

public class Main {
    public static void main(String[] args) {
        Ink ink = new BlueInk();
        Refill refill = new Refill(ink, 10);
        Nib nib = new Nib("fine");

        Pen pen = new Pen(refill, nib);

        pen.start();
        pen.write("Hello");
        pen.write("World!!!");
        pen.refill(5);
        pen.write("Again writing");
        pen.close();
    }
}