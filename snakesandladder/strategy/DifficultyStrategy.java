package snakesandladder.strategy;

public interface DifficultyStrategy {
    int getSnakeCount(int n);
    int getLadderCount(int n);
}