package animalwiki.backend.repository.impl;

import animalwiki.backend.repository.QueryRepository;
import animalwiki.backend.repository.RedisRepository;
import animalwiki.backend.util.AnimalWikiStringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class QueryRepositoryImpl implements QueryRepository {

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public List<String> searchFor(String query) {
        List<String> animals = redisRepository.smembers(AnimalWikiStringTools.getAnimalNamesSetKey());
        return animals.stream().filter(animal -> animal.contains(query)).collect(Collectors.toList());
    }
}
