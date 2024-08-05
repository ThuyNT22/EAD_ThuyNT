package org.example.eadtest_thuynt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    // Endpoint to clear all caches
    @DeleteMapping("/clearAll")
    public String clearAllCaches() {
        cacheManager.getCacheNames().forEach(cacheName -> {
            cacheManager.getCache(cacheName).clear();
        });
        return "All caches cleared";
    }

    // Example of a cacheable endpoint
    @Cacheable(value = "exampleCache", key = "#id")
    @GetMapping("/get/{id}")
    public String getFromCache(@PathVariable String id) {
        // Simulate a long running operation
        return "Data for ID: " + id;
    }

    // Endpoint to clear a specific cache by name
    @CacheEvict(value = "exampleCache", key = "#id")
    @DeleteMapping("/clear/{id}")
    public String clearCacheById(@PathVariable String id) {
        return "Cache for ID: " + id + " cleared";
    }
}
