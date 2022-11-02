package animalwiki.backend.repository.impl;

import animalwiki.backend.model.Animal;
import animalwiki.backend.model.type.Vertebrates;
import animalwiki.backend.repository.RedisRepository;
import animalwiki.backend.repository.TypeRepository;
import animalwiki.backend.service.AnimalService;
import animalwiki.backend.util.AnimalWikiStringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TypeRepositoryImpl implements TypeRepository {

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private AnimalService animalService;

    @Override
    public List<String> fetchAllType() {
        return redisRepository.smembers(AnimalWikiStringTools.getAnimalTypesSetKey());
    }

    @Override
    public List<Animal> fetchType(Vertebrates type) {
        List<Animal> animals = new ArrayList<>();
        for (String name : redisRepository.smembers(AnimalWikiStringTools.getAnimalNamesSetKey()))
        {
            Animal animal = animalService.fetchAnimalByName(name);
            if (animal.getType() == type)
            {
                animals.add(animal);
            }
        }
        return  animals;
    }
}
