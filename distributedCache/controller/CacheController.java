package distributedCache.controller;

import distributedCache.service.CacheService;

public class CacheController<K, V> {

    private CacheService<K, V> cacheService;

    public CacheController(CacheService<K, V> cacheService) {
        this.cacheService = cacheService;
    }

    public V get(K key) {
        return cacheService.get(key);
    }

    public void put(K key, V value) {
        cacheService.put(key, value);
    }
}