package rateLimiter.core;

import rateLimiter.strategy.RateLimitingStrategy;

public class RateLimiterFactory {

    public static RateLimiterService create(RateLimitingStrategy strategy) {
        return new RateLimiterService(strategy);
    }
}