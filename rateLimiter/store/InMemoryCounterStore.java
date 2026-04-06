package rateLimiter.store;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryCounterStore implements CounterStore {

    private final ConcurrentHashMap<String, AtomicInteger> store = new ConcurrentHashMap<>();

    private String buildKey(String key, long windowStart) {
        return key + "_" + windowStart;
    }

    @Override
    public int increment(String key, long windowStart) {
        String compositeKey = buildKey(key, windowStart);

        store.putIfAbsent(compositeKey, new AtomicInteger(0));
        return store.get(compositeKey).incrementAndGet();
    }

    @Override
    public int get(String key, long windowStart) {
        String compositeKey = buildKey(key, windowStart);

        return store.getOrDefault(compositeKey, new AtomicInteger(0)).get();
    }

    @Override
    public void reset(String key, long windowStart) {
        String compositeKey = buildKey(key, windowStart);
        store.remove(compositeKey);
    }
}