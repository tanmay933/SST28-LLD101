package rateLimiter.api;

public class RateLimitRequest {
    private final String key;

    public RateLimitRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}