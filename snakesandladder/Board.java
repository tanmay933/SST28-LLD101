package snakesandladder;
import snakesandladder.entity.Jump;
import java.util.*;

public class Board {
    private int size;
    private Map<Integer, Jump> jumps;

    public Board(int n, String difficulty) {
        this.size = n * n;
        this.jumps = new HashMap<>();
        initialize(n, difficulty);
    }

    private void initialize(int n, String difficulty) {
        int count = n;

        Random rand = new Random();

        while (jumps.size() < count * 2) {
            int start = rand.nextInt(size - 1) + 1;
            int end = rand.nextInt(size - 1) + 1;

            if (start == end) continue;

            if (start > end) {
                jumps.put(start, new Jump(start, end));
            } else {
                jumps.put(start, new Jump(start, end));
            }
        }
    }

    public int resolveJump(int position) {
        while (jumps.containsKey(position)) {
            position = jumps.get(position).getEnd();
        }
        return position;
    }
}