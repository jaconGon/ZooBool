package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Animal;
import br.com.unifal.zoobool.exception.AnimalNotFoundException;
import br.com.unifal.zoobool.exception.InvalidAnimalException;
import br.com.unifal.zoobool.repository.AnimalRepository;
import br.com.unifal.zoobool.service.AnimalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @InjectMocks
    private AnimalService service;

    @Mock
    private AnimalRepository repository;

    @Test
    @DisplayName("#findById > When the id is null > Throw an exception")
    void findByIdWhenTheIdIsNullThrowAnException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.findById(null));
    }

    @Test
    @DisplayName("#findById > When the id is not null > When a animal is found > Return the animal")
    void findByIdWhenTheIdIsNotNullWhenAnAnimalIsFoundReturnTheAnimal() {
        when(repository.findById(1)).thenReturn(Optional.of(Animal.builder()
                .id_animal(1)
                .tamanho("Pequeno")
                .n_cientifico("Iguana iguana")
                .id_habitat(41)
                .especie("Iguana Verde")
                .id_vet(2)
                .nome("Iggy")
                .idade(3)
                .peso(2.50)
                .build()));
        Animal response = service.findById(1);
        assertAll(
                () -> assertEquals(1, response.getId_animal()),
                () -> assertEquals("Pequeno", response.getTamanho()),
                () -> assertEquals("Iguana iguana", response.getN_cientifico()),
                () -> assertEquals(41, response.getId_habitat()),
                () -> assertEquals("Iguana Verde", response.getEspecie()),
                () -> assertEquals(2, response.getId_vet()),
                () -> assertEquals("Iggy", response.getNome()),
                () -> assertEquals(3, response.getIdade()),
                () -> assertEquals(2.50, response.getPeso())
        );

    }

    @Test
    @DisplayName("#findById > When the id is not null > When no animal is found > Throw an exception")
    void findByIdWhenTheIdIsNotNullWhenNoAnimalIsFoundThrowAnException() {
        when(repository.findById(2)).thenReturn(Optional.empty());
        assertThrows(AnimalNotFoundException.class, () ->
                service.findById(2));
    }

    @Test
    @DisplayName("#deleteAnimal > When the id is null > Throw an exception")
    void deleteAnimalWhenTheIdIsNullThrowException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAnimal(null));
    }


    @Test
    @DisplayName("#deleteAnimal > When the id is not null but the animal doesnt exist > Throw an exception")
    void deleteAnimalWhenIdIsNotNullAndGuestDoesntExistThrowException() {
        when(repository.findById(1)).thenReturn(Optional.empty());
        assertThrows(AnimalNotFoundException.class, () -> service.deleteAnimal(1));
    }

    @Test
    @DisplayName("#deleteAnimal > When the animal exist > Delete the animal")
    void deleteByIdWhenTheAnimalExist() {
        when(repository.findById(1)).thenReturn(
                Optional.of(
                        Animal.builder().id_animal(1).tamanho("Pequeno").n_cientifico("Iguana iguana").especie("Iguana Verde").nome("Iggy").id_habitat(41).id_vet(2).idade(3).peso(2.50).build()
                )
        );
        Animal response = service.findById(1);
        assertAll(
                () -> assertEquals(1, response.getId_animal()),
                () -> assertEquals("Pequeno", response.getTamanho()),
                () -> assertEquals("Iguana iguana", response.getN_cientifico()),
                () -> assertEquals(41, response.getId_habitat()),
                () -> assertEquals("Iguana Verde", response.getEspecie()),
                () -> assertEquals(2, response.getId_vet()),
                () -> assertEquals("Iggy", response.getNome()),
                () -> assertEquals(3, response.getIdade()),
                () -> assertEquals(2.50, response.getPeso())

        );

        when(repository.findById(1)).thenReturn(Optional.empty());
        assertThrows(
                AnimalNotFoundException.class,
                () -> service.deleteAnimal(response.getId_animal())
        );
    }
    @Test
    @DisplayName("#saveAnimal > When a animal is saved > Verify that the repository's save method is called")
    void saveAnimalWhenAAnimalIsSavedVerifyRepositorySaveMethod() {
        Animal animal = Animal.builder().id_animal(1).tamanho("Pequeno").n_cientifico("Iguana iguana").especie("Iguana Verde").nome("Iggy").id_habitat(41).id_vet(2).idade(3).peso(2.50).build();
        service.saveAnimal(animal);
        verify(repository, times(1)).save(animal);
    }

    @Test
    @DisplayName("#getAllAnimals > When there are no registered animals > Returns an empty list")
    void getAllAnimalsWhenThereAreNoRegisteredAnimalsReturnsAnEmptyList(){
        List<Animal> response = service.getAllAnimals();
        Assertions.assertTrue(response.isEmpty());
    }
    @Test
    @DisplayName("#getAllAnimals > When there are registered animals > Returns the list of animals")
    void getAllAnimalsWhenThereAreRegisteredAnimalsReturnsTheListOfAnimals(){
        when(service.getAllAnimals()).thenReturn(List.of(Animal.builder()
                .id_animal(1)
                .tamanho("Pequeno")
                .n_cientifico("Iguana iguana")
                .especie("Iguana Verde")
                .nome("Iggy")
                .id_habitat(41)
                .id_vet(2)
                .idade(3)
                .peso(2.50)
                .build()));
        List<Animal> response = service.getAllAnimals();
        assertAll(
                () -> assertEquals(1, response.get(0).getId_animal()),
                () -> assertEquals("Pequeno", response.get(0).getTamanho()),
                () -> assertEquals("Iguana iguana", response.get(0).getN_cientifico()),
                () -> assertEquals(41, response.get(0).getId_habitat()),
                () -> assertEquals("Iguana Verde", response.get(0).getEspecie()),
                () -> assertEquals(2, response.get(0).getId_vet()),
                () -> assertEquals("Iggy", response.get(0).getNome()),
                () -> assertEquals(3, response.get(0).getIdade()),
                () -> assertEquals(2.50, response.get(0).getPeso())


        );
    }

    @Test
    public void testAddAnimalWithValidData() {
        Animal animal = new Animal(1,"Pequeno", "Iguana iguana", "Iguana Verde", "Iggy", 41, 2, 3, 2.50 );

        when(repository.save(animal)).thenReturn(animal);

        Animal result = service.add(animal);


        assertNotNull(result);
        assertEquals(animal, result);

        verify(repository, times(1)).save(animal);
    }

    @Test
    public void testAddAnimalWithInvalidData() {

        Animal animal = new Animal(1,"Pequeno", null, "Iguana Verde", "Iggy", 41, 2, 3, 2.50);

        assertThrows(InvalidAnimalException.class, () -> service.add(animal));

        verify(repository, never()).save(animal);
    }
}