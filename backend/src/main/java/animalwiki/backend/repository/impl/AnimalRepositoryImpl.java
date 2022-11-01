package animalwiki.backend.repository.impl;

import animalwiki.backend.model.Animal;
import animalwiki.backend.repository.RedisRepository;
import animalwiki.backend.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository {

    @Autowired
    private RedisRepository redisRepository;

    public static final String ANIMALNAMESET = "ANIMALNAMES";

    @Override
    public boolean saveAnimal(Animal animal) {
        try {
            redisRepository.hmset(animal.getName(), Map.of(
                    "name", animal.getName(),
                    "img", animal.getImg(),
                    "desc", animal.getDesc()));
            redisRepository.sadd(ANIMALNAMESET, animal.getName());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Animal> fetchAllAnimal() {
        List<Animal> animals = new ArrayList<>();
        for (String name : redisRepository.smembers(ANIMALNAMESET))
        {
            animals.add(fetchAnimalByName(name));
        }
        return  animals;
    }

    @Override
    public Animal fetchAnimalByName(String name) {
        Animal animal = new Animal();
        Map<String, String> values = redisRepository.hgetall(name);
        animal.setName(values.get("name"));
        animal.setImg(values.get("img"));
        animal.setDesc(values.get("desc"));
        return animal;
    }

    @Override
    public void deleteAnimal(String name) {
        redisRepository.del(name);
        redisRepository.srem(ANIMALNAMESET, name);
    }

    @Override
    public void updateAnimal(String name, Animal animal) {
        redisRepository.hmset(name, Map.of(
                "name", animal.getName(),
                "img", animal.getImg(),
                "desc", animal.getDesc()));
    }
}
