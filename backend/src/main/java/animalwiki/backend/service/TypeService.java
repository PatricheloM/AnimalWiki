package animalwiki.backend.service;

import animalwiki.backend.model.Animal;
import animalwiki.backend.model.type.Vertebrates;

import java.util.List;

public interface TypeService {

    List<String> fetchAllType();

    List<Animal> fetchType(Vertebrates type);
}
