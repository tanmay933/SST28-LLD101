package distributedCache.distribution;

import distributedCache.node.CacheNode;
import java.util.List;

public class ConsistentHashingStrategy<K, V> implements DistributionStrategy<K, V> {

    @Override
    public CacheNode<K, V> getNode(K key, List<CacheNode<K, V>> nodes) {
        // TODO (future)
        return null;
    }
}