package animalwiki.backend.controller;

import animalwiki.backend.model.Animal;
import animalwiki.backend.model.Message;
import animalwiki.backend.service.QueryService;
import animalwiki.backend.util.AnimalWikiStringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/query")
public class QueryController {

    @Autowired
    QueryService queryService;

    @GetMapping(value = "/{query}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> fetchAnimalByName(@PathVariable("query") String query) {
        List<String> animals = queryService.searchFor(query);
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }
}
