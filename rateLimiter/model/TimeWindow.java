package rateLimiter.model;

public class TimeWindow {

    private final long startTime;
    private final long windowSizeMillis;

    public TimeWindow(long startTime, long windowSizeMillis) {
        this.startTime = startTime;
        this.windowSizeMillis = windowSizeMillis;
    }

    public boolean isExpired(long currentTime) {
        return currentTime - startTime >= windowSizeMillis;
    }

    public long getStartTime() {
        return startTime;
    }
}