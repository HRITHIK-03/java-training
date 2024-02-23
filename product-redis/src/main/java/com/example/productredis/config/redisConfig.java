package com.example.productredis.config;

import java.io.Serializable;

import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking.ClearCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import jakarta.annotation.PostConstruct;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class redisConfig {
	@Autowired
	private CacheManager cacheManager;
	
	@Value("${spring.redis.host}")
	private String redisHost;
	
	@Value("${spring.redis.port}")
	private int redisPort;
	
//	@Bean
//	public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory)
//	{
//		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
//		template.setKeySerializer(new StringRedisSerializer());
//		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//		template.setConnectionFactory(redisConnectionFactory);
//		return template;		
//	}
	
//	@Bean
//	public RedisCacheManagerBuilder cacheManager(RedisConnectionFactory factory)
//	{
//		RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig();
//		RedisCacheConfiguration redisCacheConfiguration=config.serializeKeysWith(RedisSerializationContext
//				.SerializationPair.fromSerializer(new StringRedisSerializer()))
//				.serializeValuesWith(RedisSerializationContext.SerializationPair
//						.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//		
//		RedisCacheManagerBuilder redisCacheManager=RedisCacheManager.builder(factory).cacheDefaults(redisCacheConfiguration);
//		return redisCacheManager;
//	}
	
//	@PostConstruct
//	public void clearCache()
//	{
//		System.out.println("clear all");
//		Jedis jedis=new Jedis();
//		((Object) jedis).flushAll(redisHost, redisPort, 1000);
//		jedis.close();
//	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}

}
