package animalwiki.backend.test;

import animalwiki.backend.controller.AnimalController;
import animalwiki.backend.model.Animal;
import animalwiki.backend.model.type.Vertebrates;
import animalwiki.backend.service.AnimalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class AnimalTest {

    private Animal animal;

    @InjectMocks
    private AnimalController animalController;

    @Mock
    private AnimalService animalService;

    @BeforeEach
    public void beforeEach() {
        animal = new Animal();
    }

    @Test
    public void testShouldReturnOkWhenSavingAnimalGivenAValidAnimalEntity() {

        // Given
        animal.setName("Cat");
        animal.setImg("A");
        animal.setExtinct(false);
        animal.setDesc("Cute little cat meow");
        animal.setType(Vertebrates.MAMMAL);

        // When
        Mockito.when(animalService.animalExists("Cat")).thenReturn(false);
        HttpStatus result = animalController.saveAnimal(animal).getStatusCode();

        // Then
        Assertions.assertEquals(HttpStatus.OK, result);
    }

    @Test
    public void testShouldReturnConflictWhenSavingAnimalGivenAnExistingAnimalEntity() {

        // Given
        animal.setName("Cat");
        animal.setImg("A");
        animal.setExtinct(false);
        animal.setDesc("Cute little cat meow");
        animal.setType(Vertebrates.MAMMAL);

        // When
        Mockito.when(animalService.animalExists("Cat")).thenReturn(true);
        HttpStatus result = animalController.saveAnimal(animal).getStatusCode();

        // Then
        Assertions.assertEquals(HttpStatus.CONFLICT, result);
    }

    @Test
    public void testShouldReturnBadRequestWhenSavingAnimalGivenAnInvalidAnimalEntity() {

        // Given
        animal.setName("Cat");
        animal.setExtinct(false);
        animal.setDesc("Cute little cat meow");
        animal.setType(Vertebrates.MAMMAL);

        // When
        HttpStatus result = animalController.saveAnimal(animal).getStatusCode();

        // Then
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    public void testShouldReturnOkWhenFetchingAnimalGivenExistingAnimalName() {

        // Given
        animal.setName("Cat");
        animal.setImg("A");
        animal.setExtinct(false);
        animal.setDesc("Cute little cat meow");
        animal.setType(Vertebrates.MAMMAL);

        // When
        Mockito.when(animalService.fetchAnimalByName("Cat")).thenReturn(animal);
        HttpStatus result = animalController.fetchAnimalByName("Cat").getStatusCode();

        // Then
        Assertions.assertEquals(HttpStatus.OK, result);
    }

    @Test
    public void testShouldReturnNotFoundWhenFetchingAnimalGivenNonexistentAnimalName() {

        // Given
        // When
        Mockito.when(animalService.fetchAnimalByName("Cat")).thenReturn(animal);
        HttpStatus result = animalController.fetchAnimalByName("Cat").getStatusCode();

        // Then
        Assertions.assertEquals(HttpStatus.NOT_FOUND, result);
    }

}
