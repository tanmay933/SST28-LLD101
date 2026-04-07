package distributedCache.service;

import distributedCache.distribution.DistributionStrategy;
import distributedCache.node.CacheNode;
import distributedCache.repository.Database;

import java.util.List;

public class DistributedCacheService<K, V> implements CacheService<K, V> {

    private List<CacheNode<K, V>> nodes;
    private DistributionStrategy<K, V> strategy;
    private Database<K, V> database;

    public DistributedCacheService(List<CacheNode<K, V>> nodes,
                                   DistributionStrategy<K, V> strategy,
                                   Database<K, V> database) {
        this.nodes = nodes;
        this.strategy = strategy;
        this.database = database;
    }

    @Override
    public V get(K key) {
        CacheNode<K, V> node = strategy.getNode(key, nodes);

        V value = node.get(key);
        if (value != null) return value;

        value = database.get(key);
        if (value != null) {
            node.put(key, value);
        }

        return value;
    }

    @Override
    public void put(K key, V value) {
        CacheNode<K, V> node = strategy.getNode(key, nodes);
        node.put(key, value);

        database.put(key, value);
    }
}