package rateLimiter.strategy;

public interface RateLimitingStrategy {
    boolean allow(String key);
}