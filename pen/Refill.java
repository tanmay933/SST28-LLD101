package pen;

import pen.ink.Ink;

public class Refill {
    private Ink ink;
    private int level;

    public Refill(Ink ink, int initialLevel) {
        this.ink = ink;
        this.level = initialLevel;
    }

    public boolean hasInk(int required) {
        return level >= required;
    }

    public void consume(int amount) {
        if (amount <= level) {
            level -= amount;
        }
    }

    public void refill(int amount) {
        level += amount;
    }

    public int getLevel() {
        return level;
    }

    public Ink getInk() {
        return ink;
    }
}