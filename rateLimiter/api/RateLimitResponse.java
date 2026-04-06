package rateLimiter.api;

public class RateLimitResponse {
    private final boolean allowed;

    public RateLimitResponse(boolean allowed) {
        this.allowed = allowed;
    }

    public boolean isAllowed() {
        return allowed;
    }
}