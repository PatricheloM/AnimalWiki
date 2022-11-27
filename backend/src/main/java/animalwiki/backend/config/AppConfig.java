package animalwiki.backend.config;

import animalwiki.backend.model.RedisConfig;
import animalwiki.backend.util.exception.ConfigNotFoundException;
import animalwiki.backend.util.json.ObjectFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class AppConfig {

    @Bean
    JedisPool jedisPool() {
        RedisConfig redisConfig;
        try {
            redisConfig = ObjectFactory.produce(AppConfig.class.getResourceAsStream("redis.json"), RedisConfig.class);
        } catch (Exception e) {
            throw new ConfigNotFoundException(e);
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfig.getMaxPool());
        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdlePool());
        jedisPoolConfig.setMinIdle(redisConfig.getMinIdlePool());
        return new JedisPool(jedisPoolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout(), redisConfig.getPassword());
    }
}
