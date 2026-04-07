package distributedCache.config;

public class CacheConfig {

    private int numberOfNodes;
    private int capacityPerNode;
    private String evictionPolicy;       // "LRU"
    private String distributionStrategy; // "MODULO"

    public CacheConfig(int numberOfNodes, int capacityPerNode,
                       String evictionPolicy, String distributionStrategy) {
        this.numberOfNodes = numberOfNodes;
        this.capacityPerNode = capacityPerNode;
        this.evictionPolicy = evictionPolicy;
        this.distributionStrategy = distributionStrategy;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getCapacityPerNode() {
        return capacityPerNode;
    }

    public String getEvictionPolicy() {
        return evictionPolicy;
    }

    public String getDistributionStrategy() {
        return distributionStrategy;
    }
}