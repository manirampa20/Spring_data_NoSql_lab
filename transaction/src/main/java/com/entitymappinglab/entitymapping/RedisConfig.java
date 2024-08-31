package com.entitymappinglab.entitymapping;//package com.entitymappinglab.entitymapping;
//
//import com.entitymappinglab.entitymapping.modules.Doctor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory();  // LettuceConnectionFactory is the default connection factory for Redis in Spring
//    }
//
//    @Bean
//    public RedisTemplate<String, Doctor> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Doctor> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return template;
//    }
//}
//
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.data.redis.connection.RedisConnectionFactory;
////import org.springframework.data.redis.core.RedisTemplate;
////import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
////import org.springframework.data.redis.serializer.StringRedisSerializer;
////
////@Configuration
////public class RedisConfig {
////
////    @Bean
////    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
////        RedisTemplate<String, Object> template = new RedisTemplate<>();
////        template.setConnectionFactory(connectionFactory);
////        template.setKeySerializer(new StringRedisSerializer());
////        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
////        return template;
////    }
////}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // Configure the Redis connection factory (default settings)
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
