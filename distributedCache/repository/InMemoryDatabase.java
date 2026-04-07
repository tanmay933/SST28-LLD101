package distributedCache.repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase<K, V> implements Database<K, V> {

    private Map<K, V> store = new HashMap<>();

    @Override
    public V get(K key) {
        return store.get(key);
    }

    @Override
    public void put(K key, V value) {
        store.put(key, value);
    }
}