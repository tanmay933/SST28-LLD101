package rateLimiter.util;

public class SystemTimeProvider implements TimeProvider {

    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}