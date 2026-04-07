package distributedCache.node;

import distributedCache.eviction.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCacheNode<K, V> implements CacheNode<K, V> {

    private int capacity;
    private Map<K, V> cache;
    private EvictionPolicy<K> evictionPolicy;

    public InMemoryCacheNode(int capacity, EvictionPolicy<K> evictionPolicy) {
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.cache = new HashMap<>();
    }

    @Override
    public V get(K key) {
        if (!cache.containsKey(key)) return null;

        evictionPolicy.keyAccessed(key);
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            K evictKey = evictionPolicy.evictKey();
            if (evictKey != null) {
                cache.remove(evictKey);
            }
        }

        cache.put(key, value);
        evictionPolicy.keyAccessed(key);
    }
}