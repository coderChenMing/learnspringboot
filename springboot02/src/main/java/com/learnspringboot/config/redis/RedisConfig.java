package com.learnspringboot.config.redis;/*
 * Project: springboot03
 * File Created at 2021-07-04 17:26:17:26
 * @Type RedisConfig.java
 * @Desc redis配置,springboot2.x 不再使用jedis,而是Lettuce(netty)
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 17:26
 * @version 1.0.0
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    /**
     * 创建JedisPoolConfig对象，配置连接池
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.dev.pool")
    public JedisPoolConfig getJedisConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大空闲连接数
//        poolConfig.setMaxIdle(10);
//        poolConfig.setMinIdle(5);
//        poolConfig.setMaxTotal(20);

        return poolConfig;
    }

    /**
     * 创建JedisConnectionFactory,配置连接redis信息
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.dev")
    public JedisConnectionFactory getJedisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(poolConfig);
//        factory.setHostName("192.168.137.37");
//        factory.setPort(6380);
//        factory.setPassword("123456");
        return factory;
    }

    /**
     * 创建 RedisTemplate,并设置序列化
     */
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(JedisConnectionFactory factory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //设置序列化器
        StringRedisSerializer serializer=new StringRedisSerializer();
        redisTemplate.setConnectionFactory(factory);
        // 为Key设置序列化器
        redisTemplate.setKeySerializer(serializer);
        // 为value设置序列化器
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        return redisTemplate;
    }
}
