package com.lilium.redis.service;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RedisListCache {
    private RedisTemplate<String, Object> redisTemplate;
    private ListOperations<String, Object> listOperations;

    public RedisListCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        listOperations = redisTemplate.opsForList();
    }
    // something to store for us to read later.
    //this part adds into redis cache, we added using the "key"
    @PostConstruct
    public void setup(){
        listOperations.leftPush("key", "hello there");
        System.out.println(listOperations.rightPop("key"));
    }
}
