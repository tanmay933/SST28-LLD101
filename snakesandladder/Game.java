package snakesandladder;

import java.util.*;

public class Game {
    private Board board;
    private Dice dice;
    private Queue<Player> players;
    private int winningPosition;

    public Game(int n, int playerCount, String difficulty) {
        this.board = new Board(n, difficulty);
        this.dice = new Dice();
        this.players = new LinkedList<>();
        this.winningPosition = n * n;

        for (int i = 1; i <= playerCount; i++) {
            players.add(new Player("P" + i));
        }
    }

    public void start() {
        while (players.size() > 1) {
            Player player = players.poll();

            int roll = dice.roll();
            int nextPos = player.getPosition() + roll;

            if (nextPos > winningPosition) {
                players.add(player);
                continue;
            }

            nextPos = board.resolveJump(nextPos);
            player.setPosition(nextPos);

            System.out.println(player.getName() + " rolled " + roll + " → " + nextPos);

            if (nextPos == winningPosition) {
                System.out.println(player.getName() + " wins!");
            } else {
                players.add(player);
            }
        }
    }
}