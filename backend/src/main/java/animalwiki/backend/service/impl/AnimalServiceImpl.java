package animalwiki.backend.service.impl;

import animalwiki.backend.model.Animal;
import animalwiki.backend.repository.AnimalRepository;
import animalwiki.backend.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public void saveAnimal(Animal animal) {
        animalRepository.saveAnimal(animal);
    }

    @Override
    public List<Animal> fetchAllAnimal() {
        return animalRepository.fetchAllAnimal();
    }

    @Override
    public Animal fetchAnimalByName(String name) {
        return animalRepository.fetchAnimalByName(name);
    }

    @Override
    public void deleteAnimal(String name) {
        animalRepository.deleteAnimal(name);
    }

    @Override
    public void updateAnimal(String name, Animal animal) {
        animalRepository.updateAnimal(name, animal);
    }

    @Override
    public boolean animalExists(String name) {
        return animalRepository.animalExists(name);
    }
}
