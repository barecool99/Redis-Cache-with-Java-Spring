package com.lilium.redis.service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service // how we can do CRUD from cache
public class RedisValueCache {
    private final ValueOperations<String,Object> valueOps;
    //constructor
    public RedisValueCache(final RedisTemplate<String, Object> redisTemplate) {
        valueOps = redisTemplate.opsForValue();
    }
    //we want to cache something, so create method here-K:key for key and V:object for cache
    //this is why REDIS is class, you can call timeouts and such in below method
    // this method can UPDATE cache as well
    public void cache(final String key, final Object data){
       // valueOps.set(key, data);
        valueOps.set(key,data, 4000, TimeUnit.MILLISECONDS);
    }
    //fetch something from cache, we will pass string as key and we request value from server
    public Object getCachedValue(final String key){
        return valueOps.get(key);
    }
    // delete something from cache based on string key we pass
    public void deleteCachedValue(final String key){
        valueOps.getOperations().delete(key);
    }
}
