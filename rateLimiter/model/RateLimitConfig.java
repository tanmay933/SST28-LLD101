package rateLimiter.model;

public class RateLimitConfig {

    private final int limit;
    private final long windowSizeMillis;

    public RateLimitConfig(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
    }

    public int getLimit() {
        return limit;
    }

    public long getWindowSizeMillis() {
        return windowSizeMillis;
    }
}