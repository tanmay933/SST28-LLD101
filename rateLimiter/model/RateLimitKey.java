package rateLimiter.model;

public class RateLimitKey {

    private final String key;

    public RateLimitKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}