package snakesandladder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int players = sc.nextInt();
            String difficulty = sc.next();
            Game game = new Game(n, players, difficulty);
            game.start();
        }
    }
}