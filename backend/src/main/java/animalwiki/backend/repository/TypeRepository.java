package animalwiki.backend.repository;

import animalwiki.backend.model.Animal;
import animalwiki.backend.model.type.Vertebrates;

import java.util.List;

public interface TypeRepository {

    List<String> fetchAllType();

    List<Animal> fetchType(Vertebrates type);
}
