package distributedCache.distribution;

import distributedCache.node.CacheNode;
import java.util.List;

public class ModuloBasedStrategy<K, V> implements DistributionStrategy<K, V> {

    @Override
    public CacheNode<K, V> getNode(K key, List<CacheNode<K, V>> nodes) {
        int index = Math.abs(key.hashCode()) % nodes.size();
        return nodes.get(index);
    }
}