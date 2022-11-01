package animalwiki.backend.repository;

import animalwiki.backend.model.Animal;

import java.util.List;

public interface AnimalRepository {

    boolean saveAnimal(Animal animal);

    List<Animal> fetchAllAnimal();

    Animal fetchAnimalByName(String name);

    void deleteAnimal(String name);

    void updateAnimal(String name, Animal animal);
}
