package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Animal;
import br.com.unifal.zoobool.exception.AnimalNotFoundException;
import br.com.unifal.zoobool.exception.InvalidAnimalException;
import br.com.unifal.zoobool.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class AnimalService {

    private final AnimalRepository repository;

    public List<Animal> getAllAnimals(){
        //TODO: Fazer a conexão com o BD
        return repository.findAll();
    }

    public Animal findById(Integer id){
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new AnimalNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Animal add(Animal animal) {
        if(Objects.isNull(animal) || Objects.isNull(animal.getId_animal())
                || Objects.isNull(animal.getNome()) || Objects.isNull(animal.getPeso())
                || Objects.isNull(animal.getIdade()) || Objects.isNull(animal.getEspecie())
                || Objects.isNull(animal.getTamanho()) || Objects.isNull(animal.getId_vet())
                || Objects.isNull(animal.getN_cientifico()) || Objects.isNull(animal.getId_habitat())
        ) {
            throw new InvalidAnimalException();
        }
        return repository.save(animal);
    }

}
