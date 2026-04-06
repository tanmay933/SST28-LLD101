package rateLimiter.core;

import rateLimiter.api.*;
import rateLimiter.strategy.RateLimitingStrategy;

public class RateLimiterService implements RateLimiter {

    private final RateLimitingStrategy strategy;

    public RateLimiterService(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public RateLimitResponse isAllowed(RateLimitRequest request) {
        boolean allowed = strategy.allow(request.getKey());
        return new RateLimitResponse(allowed);
    }
}