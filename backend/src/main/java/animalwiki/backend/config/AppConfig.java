package animalwiki.backend.config;

import animalwiki.backend.repository.RedisRepository;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@EnableCaching
public class AppConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost", 6379);
        redisStandaloneConfiguration.setPassword(RedisPassword.of("password"));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisRepository redisRepository() {
        return new RedisRepository(jedisConnectionFactory().getConnection());
    }
}
