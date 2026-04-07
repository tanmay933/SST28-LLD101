package distributedCache.factory;

import distributedCache.eviction.EvictionPolicy;
import distributedCache.eviction.LRUEvictionPolicy;

public class EvictionPolicyFactory {

    public static <K> EvictionPolicy<K> create(String type) {
        if ("LRU".equalsIgnoreCase(type)) {
            return new LRUEvictionPolicy<>();
        }

        throw new IllegalArgumentException("Unsupported Eviction Policy: " + type);
    }
}