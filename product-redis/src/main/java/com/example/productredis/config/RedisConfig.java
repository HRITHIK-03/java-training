package com.example.productredis.config;

//package com.example.productredis.config;
//
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//@AutoConfigureAfter(RedisAutoConfiguration.class)
//@EnableCaching
//public class redisConfig  {
//
////	private final CacheManager cacheManager;
////	
////	public redisConfig(@Lazy CacheManager cacheManager) {
////		super();
////		this.cacheManager = cacheManager;
////	}
////
////	@Value("${spring.data.redis.host}")
////	private String redisHost;
////	
////	@Value("${spring.data.redis.port}")
////	private int redisPort;
////	
////
////	
////	@Bean
////	JedisConnectionFactory jedisConnectionFactory() {
////	    return new JedisConnectionFactory();
////	}
////
////	@Bean
////	public RedisTemplate<String, Object> redisTemplate() {
////	    RedisTemplate<String, Object> template = new RedisTemplate<>();
////	    template.setConnectionFactory(jedisConnectionFactory());
////	    template.setKeySerializer(new StringRedisSerializer());
////        template.setHashKeySerializer(new StringRedisSerializer());
////        template.setHashKeySerializer(new GenericToStringSerializer<Object>(Object.class));
////        //template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
////        template.setEnableTransactionSupport(true);
////        template.afterPropertiesSet();
////	    return template;
////	}
////	
//	@Bean
//	public MessageListenerAdapter messageListener()
//	{
//		return new MessageListenerAdapter(new redisMessageSubscriber());
//	}
//	
//	@Bean
//	public ChannelTopic topic()
//	{
//		return new ChannelTopic("__keyevent@0__:evicted");
//	}
////	@Bean
////	public RedisMessageListenerContainer redisContainer(RedisConnectionFactory redisConnectionFactory)
////	{
////		RedisMessageListenerContainer container= new RedisMessageListenerContainer();
////		container.setConnectionFactory(redisConnectionFactory);
////		container.addMessageListener(messageListener(), topic());
////		return container;
////	}
//	
//	 @Bean
//	    public LettuceConnectionFactory connectionFactory() {
//	        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//	        configuration.setHostName(properties().getHost());
//	        configuration.setPort(properties().getPort());
//	        return new LettuceConnectionFactory(configuration);
//	    }
//
//
//	    @Bean
//	    public RedisTemplate<String,Object> redisTemplate() {
//	        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
//	        redisTemplate.setConnectionFactory(connectionFactory());
//	        redisTemplate.setKeySerializer(new StringRedisSerializer());
//	        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//	        return  redisTemplate;
//	    }
//
//
//	    @Bean
//	    @Primary
//	    public RedisProperties properties() {
//	        return new RedisProperties();
//	    }
//
//}

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory connectionFactory(RedisProperties properties) {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(properties.getHost());
        configuration.setPort(properties.getPort());
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JsonRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    @Primary
    public RedisProperties properties() {
        return new RedisProperties();
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(LettuceConnectionFactory connectionFactory,
                                                                       MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //container.addMessageListener(messageListenerAdapter, new PatternTopic("__keyspace@0__:insert"));
        container.addMessageListener(messageListenerAdapter, new ChannelTopic("__keyevent@0__:evicted"));
        
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(RedisMessageSubscriber redisMessageSubscriber) {
        return new MessageListenerAdapter(redisMessageSubscriber, "onMessage");
    }

    @Bean
    public RedisMessageSubscriber redisMessageSubscriber() {
        return new RedisMessageSubscriber();
    }
}

