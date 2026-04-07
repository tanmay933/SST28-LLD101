package distributedCache.factory;

import distributedCache.distribution.DistributionStrategy;
import distributedCache.distribution.ModuloBasedStrategy;

public class DistributionStrategyFactory {

    public static <K, V> DistributionStrategy<K, V> create(String type) {
        if ("MODULO".equalsIgnoreCase(type)) {
            return new ModuloBasedStrategy<>();
        }

        throw new IllegalArgumentException("Unsupported Strategy: " + type);
    }
}