package animalwiki.backend.config;

import animalwiki.backend.model.RedisConfig;
import animalwiki.backend.repository.RedisRepository;
import animalwiki.backend.util.json.ObjectFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.io.IOException;

@Configuration
@EnableCaching
public class AppConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisConfig redisConfig;
        try {
            redisConfig = ObjectFactory.produce(AppConfig.class.getResourceAsStream("redis.json"), RedisConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisConfig.getHost(), redisConfig.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisConfig.getPassword()));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisRepository redisRepository() {
        return new RedisRepository(jedisConnectionFactory().getConnection());
    }
}
