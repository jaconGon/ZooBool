package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Animal;
import br.com.unifal.zoobool.entity.Funcionario;
import br.com.unifal.zoobool.exception.AnimalNotFoundException;
import br.com.unifal.zoobool.exception.FuncionarioNotFoundException;
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
  
   public void deleteAnimal(Integer id) {
        if (!Objects.isNull(findById(id))) {
            repository.deleteById(id);
        }
        throw new AnimalNotFoundException(String.format("Animal with id[%d] not found!!", id));
    }

    public List<Animal> orderAnimalAtoZ() {
        return repository.orderAnimalAtoZ();
    }


    public void saveAnimal(Animal animal) {
        repository.save(animal);
    }

    public List<Animal> orderAnimalZtoA() {
        return repository.orderAnimalZtoA();

    }

    public List<Animal> filtroTam() {
        return repository.filtroTam();

    }

    public List<Animal> filtroTipo() {
        return repository.filtroTipo();

    }

  
    public List<Animal> filtroNome() {
        return repository.filtroNome();

    }

    public List<Animal> filtroHabPe() {
        return repository.filtroHabPe();

    }

    public List<Animal> filtroVetPe(){
        return repository.filtroVetPe();

    }
    public List<Animal> findAnimaisComMamiferos(){
        return repository.findAnimaisComMamiferos();
    }



}
