package com.nucsaping.config;

import com.nucsaping.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    /**
     * The first type parameter, String, specifies the data type for keys.
     * This means that Redis keys are expected to be of type String.
     *
     * The second type parameter, Employee, specifies the data type for values. In this case,
     * it indicates that the values stored and retrieved using this RedisTemplate are of type Employee.
     */
    @Bean
    public RedisTemplate<String, Employee> redisTemplate() {
        RedisTemplate<String, Employee> employeeRedisTemplate = new RedisTemplate<String, Employee>();
        employeeRedisTemplate.setConnectionFactory(redisConnectionFactory());
        return employeeRedisTemplate;
    }
}
