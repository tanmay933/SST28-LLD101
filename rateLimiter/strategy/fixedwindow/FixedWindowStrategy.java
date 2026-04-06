package rateLimiter.strategy.fixedwindow;

import rateLimiter.strategy.RateLimitingStrategy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowStrategy implements RateLimitingStrategy {

    private final int limit;
    private final long windowSizeMillis;

    private final ConcurrentHashMap<String, AtomicInteger> counter = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> windowStart = new ConcurrentHashMap<>();

    public FixedWindowStrategy(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
    }

    @Override
    public boolean allow(String key) {
        long now = System.currentTimeMillis();

        windowStart.putIfAbsent(key, now);
        counter.putIfAbsent(key, new AtomicInteger(0));

        long start = windowStart.get(key);

        if (now - start >= windowSizeMillis) {
            windowStart.put(key, now);
            counter.get(key).set(0);
        }

        return counter.get(key).incrementAndGet() <= limit;
    }
}