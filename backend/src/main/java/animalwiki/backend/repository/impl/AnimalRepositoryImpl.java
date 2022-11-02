package animalwiki.backend.repository.impl;

import animalwiki.backend.model.Animal;
import animalwiki.backend.model.type.Vertebrates;
import animalwiki.backend.repository.RedisRepository;
import animalwiki.backend.repository.AnimalRepository;
import animalwiki.backend.util.AnimalWikiTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository {

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public void saveAnimal(Animal animal) {
        redisRepository.hmset(animal.getName(), Map.of(
                "name", animal.getName(),
                "img", animal.getImg(),
                "type", animal.getType().toString(),
                "extinct", animal.getExtinct().toString(),
                "desc", animal.getDesc()));
        redisRepository.sadd(AnimalWikiTools.getAnimalNamesSetKey(), animal.getName());
    }

    @Override
    public List<Animal> fetchAllAnimal() {
        List<Animal> animals = new ArrayList<>();
        for (String name : redisRepository.smembers(AnimalWikiTools.getAnimalNamesSetKey()))
        {
            animals.add(fetchAnimalByName(name));
        }
        return  animals;
    }

    @Override
    public Animal fetchAnimalByName(String name) {
        Animal animal = new Animal();
        if (redisRepository.sismember(AnimalWikiTools.getAnimalNamesSetKey(), name))
        {
            Map<String, String> values = redisRepository.hgetall(name);
            animal.setName(values.get("name"));
            animal.setImg(values.get("img"));
            animal.setType(Vertebrates.valueOf(values.get("type")));
            animal.setExtinct(Boolean.valueOf(values.get("extinct")));
            animal.setDesc(values.get("desc"));
        }
        return animal;
    }

    @Override
    public void deleteAnimal(String name) {
        redisRepository.del(name);
        redisRepository.srem(AnimalWikiTools.getAnimalNamesSetKey(), name);
    }

    @Override
    public void updateAnimal(String name, Animal animal) {
        redisRepository.hmset(name, Map.of(
                "name", animal.getName(),
                "img", animal.getImg(),
                "type", animal.getType().toString(),
                "extinct", animal.getExtinct().toString(),
                "desc", animal.getDesc()));
    }

    @Override
    public boolean animalExists(String name) {
        return redisRepository.sismember(AnimalWikiTools.getAnimalNamesSetKey(), name);
    }
}
