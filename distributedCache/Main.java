package distributedCache;

import distributedCache.config.CacheConfig;
import distributedCache.controller.CacheController;
import distributedCache.distribution.DistributionStrategy;
import distributedCache.factory.DistributionStrategyFactory;
import distributedCache.factory.EvictionPolicyFactory;
import distributedCache.node.CacheNode;
import distributedCache.node.InMemoryCacheNode;
import distributedCache.repository.Database;
import distributedCache.repository.InMemoryDatabase;
import distributedCache.service.CacheService;
import distributedCache.service.DistributedCacheService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Config
        CacheConfig config = new CacheConfig(
                3,      // nodes
                2,      // capacity per node
                "LRU",
                "MODULO"
        );

        // 2. Create nodes
        List<CacheNode<Integer, String>> nodes = new ArrayList<>();

        for (int i = 0; i < config.getNumberOfNodes(); i++) {
            nodes.add(new InMemoryCacheNode<>(
                    config.getCapacityPerNode(),
                    EvictionPolicyFactory.create(config.getEvictionPolicy())
            ));
        }

        // 3. Strategy
        DistributionStrategy<Integer, String> strategy =
                DistributionStrategyFactory.create(config.getDistributionStrategy());

        // 4. Database
        Database<Integer, String> db = new InMemoryDatabase<>();

        // preload DB (simulate real scenario)
        db.put(1, "One");
        db.put(2, "Two");
        db.put(3, "Three");

        // 5. Service
        CacheService<Integer, String> service =
                new DistributedCacheService<>(nodes, strategy, db);

        // 6. Controller
        CacheController<Integer, String> controller =
                new CacheController<>(service);

        // 🔥 Test flow
        System.out.println(controller.get(1)); // DB → Cache
        System.out.println(controller.get(1)); // Cache hit

        controller.put(4, "Four");
        System.out.println(controller.get(4));
    }
}