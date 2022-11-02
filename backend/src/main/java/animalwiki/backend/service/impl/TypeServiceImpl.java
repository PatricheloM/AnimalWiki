package animalwiki.backend.service.impl;

import animalwiki.backend.model.Animal;
import animalwiki.backend.model.type.Vertebrates;
import animalwiki.backend.repository.TypeRepository;
import animalwiki.backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Override
    public List<String> fetchAllType() {
        return typeRepository.fetchAllType();
    }

    @Override
    public List<Animal> fetchType(Vertebrates type) {
        return typeRepository.fetchType(type);
    }
}
