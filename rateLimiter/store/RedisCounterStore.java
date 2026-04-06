package rateLimiter.store;

public class RedisCounterStore implements CounterStore {

    @Override
    public int increment(String key, long windowStart) {
        // TODO: implement using Redis INCR with expiry
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int get(String key, long windowStart) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void reset(String key, long windowStart) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}