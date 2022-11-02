package animalwiki.backend.controller;

import animalwiki.backend.model.Message;
import animalwiki.backend.model.Animal;
import animalwiki.backend.service.AnimalService;
import animalwiki.backend.util.converter.AnimalConverter;
import animalwiki.backend.util.json.JsonFactory;
import animalwiki.backend.util.validator.JsonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping(value = "/animal", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveAnimal(@RequestBody Object object) {
        try {
            if (JsonValidator.validate(JsonFactory.produce(object))) {

                Animal animal = AnimalConverter.convert(object);

                if (animalService.animalExists(animal.getName()))
                    return new ResponseEntity<>(new Message("Animal already exists!"), HttpStatus.CONFLICT);
                else {
                    animalService.saveAnimal(animal);
                    return new ResponseEntity<>(animal, HttpStatus.OK);
                }
            }
            else
                return new ResponseEntity<>(new Message("Bad request!"), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new Message("Internal server error!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/animal", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Animal>> fetchAllAnimal() {
        List<Animal> animals = animalService.fetchAllAnimal();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping(value = "/animal/{name}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> fetchAnimalByName(@PathVariable("name") String name) {
        Animal animal = animalService.fetchAnimalByName(name);
        if (animal.equals(new Animal()))
            return new ResponseEntity<>(new Message("Animal not found!"), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping(value = "/animal/{name}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteAnimal(@PathVariable("name") String name) {
        Animal animal = animalService.fetchAnimalByName(name);
        if (animal.equals(new Animal()))
            return new ResponseEntity<>(new Message("Animal not found!"), HttpStatus.NOT_FOUND);
        else {
            animalService.deleteAnimal(name);
            return new ResponseEntity<>(animal, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/animal/{name}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateAnimal(@PathVariable("name") String name, @RequestBody Object object) {
        try {
            if (JsonValidator.validate(JsonFactory.produce(object))) {

                Animal newAnimal = AnimalConverter.convert(object);
                Animal animal = animalService.fetchAnimalByName(name);

                if (name.equals(newAnimal.getName()))
                {
                    if (animal.equals(new Animal()))
                        return new ResponseEntity<>(new Message("Animal not found!"), HttpStatus.NOT_FOUND);
                    else {
                        animalService.updateAnimal(name, newAnimal);
                        return new ResponseEntity<>(newAnimal, HttpStatus.OK);
                    }
                }
                else
                    return new ResponseEntity<>(new Message("Wrong name in request!"), HttpStatus.CONFLICT);
            }
            else
                return new ResponseEntity<>(new Message("Bad request!"), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new Message("Internal server error!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}