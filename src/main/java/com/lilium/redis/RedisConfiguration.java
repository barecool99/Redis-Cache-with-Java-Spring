package com.lilium.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean // need this for port and env connection
    public LettuceConnectionFactory redisConnectionFactory(){
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("localhost");
        config.setPort(6379);
       return new LettuceConnectionFactory(config);
    }
    @Bean // create redis template and set it to LettuceConnectionFactory() details.
    public RedisTemplate<String, Object> redisTemplate(){
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;

    }
}
