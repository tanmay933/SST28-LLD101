package rateLimiter.store;

public interface CounterStore {

    int increment(String key, long windowStart);

    int get(String key, long windowStart);

    void reset(String key, long windowStart);
}