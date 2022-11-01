package animalwiki.backend.service;

import animalwiki.backend.model.Animal;

import java.util.List;

public interface AnimalService {

    boolean saveAnimal(Animal animal);

    List<Animal> fetchAllAnimal();

    Animal fetchAnimalByName(String name);

    void deleteAnimal(String name);

    void updateAnimal(String name, Animal animal);
}
