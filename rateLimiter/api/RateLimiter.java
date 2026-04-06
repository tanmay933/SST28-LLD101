package rateLimiter.api;

public interface RateLimiter {
    RateLimitResponse isAllowed(RateLimitRequest request);
}