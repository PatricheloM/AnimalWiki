package animalwiki.backend.controller;

import animalwiki.backend.model.Message;
import animalwiki.backend.model.Animal;
import animalwiki.backend.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping("/animal")
    public ResponseEntity<Object> saveAnimal(@RequestBody Animal animal) {
        boolean result = animalService.saveAnimal(animal);
        if (result)
            return new ResponseEntity<>(animal, HttpStatus.OK);
        else
            return new ResponseEntity<>(new Message("Bad request!"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/animal")
    public ResponseEntity<List<Animal>> fetchAllAnimal() {
        List<Animal> animals = animalService.fetchAllAnimal();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping("/animal/{name}")
    public ResponseEntity<Object> fetchAnimalByName(@PathVariable("name") String name) {
        Animal animal = animalService.fetchAnimalByName(name);
        if (animal.equals(new Animal()))
            return new ResponseEntity<>(new Message("Animal not found!"), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/animal/{name}")
    public ResponseEntity<Object> deleteAnimal(@PathVariable("name") String name) {
        Animal animal = animalService.fetchAnimalByName(name);
        if (animal.equals(new Animal()))
            return new ResponseEntity<>(new Message("Animal not found!"), HttpStatus.NOT_FOUND);
        else {
            animalService.deleteAnimal(name);
            return new ResponseEntity<>(animal, HttpStatus.OK);
        }
    }

    @PutMapping("/animal/{name}")
    public ResponseEntity<Object> updateAnimal(@PathVariable("name") String name, @RequestBody Animal newAnimal) {
        Animal animal = animalService.fetchAnimalByName(name);
        if (animal.equals(new Animal()))
            return new ResponseEntity<>(new Message("Animal not found!"), HttpStatus.NOT_FOUND);
        else {
            animalService.updateAnimal(name, animal);
            return new ResponseEntity<>(newAnimal, HttpStatus.OK);
        }
    }
}
