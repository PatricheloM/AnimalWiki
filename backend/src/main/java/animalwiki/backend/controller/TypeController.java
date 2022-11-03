package animalwiki.backend.controller;

import animalwiki.backend.model.Animal;
import animalwiki.backend.model.type.Vertebrates;
import animalwiki.backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> fetchAllType() {
        List<String> types = typeService.fetchAllType();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping(value = "/{type}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Animal>> fetchType(@PathVariable("type") Vertebrates type) {
        List<Animal> types = typeService.fetchType(type);
        return new ResponseEntity<>(types, HttpStatus.OK);
    }
}
