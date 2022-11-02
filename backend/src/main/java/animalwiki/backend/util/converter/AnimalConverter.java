package animalwiki.backend.util.converter;

import animalwiki.backend.model.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AnimalConverter {

    private final static ObjectMapper mapper = new ObjectMapper();

    public static Animal convert(Object pojo)
    {
        return mapper.convertValue(pojo, Animal.class);
    }
}
