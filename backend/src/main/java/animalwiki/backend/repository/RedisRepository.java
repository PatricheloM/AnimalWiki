package animalwiki.backend.repository;

import org.springframework.data.redis.connection.RedisConnection;

public class RedisRepository {

    RedisConnection connection;

    public RedisRepository(RedisConnection connection) {
        this.connection = connection;
    }
}
