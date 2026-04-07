package distributedCache.node;

public interface CacheNode<K, V> {
    V get(K key);
    void put(K key, V value);
}