package distributedCache.distribution;

import distributedCache.node.CacheNode;
import java.util.List;

public interface DistributionStrategy<K, V> {
    CacheNode<K, V> getNode(K key, List<CacheNode<K, V>> nodes);
}