package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Mamifero;
import br.com.unifal.zoobool.exception.MamiferoNotFoundException;
import br.com.unifal.zoobool.exception.InvalidMamiferoException;
import br.com.unifal.zoobool.repository.MamiferoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class MamiferoService {

    private final MamiferoRepository repository;

    public List<Mamifero> getAllMamiferos(){

        return repository.findAll();
    }

    public Mamifero findById(Integer id){
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new MamiferoNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Mamifero add(Mamifero mamifero) {
        if(Objects.isNull(mamifero) || Objects.isNull(mamifero.getId_animal())
                || Objects.isNull(mamifero.getTempo_amam()) || Objects.isNull(mamifero.getTempo_gestacao())
               ) {
            throw new InvalidMamiferoException();
        }
        return repository.save(mamifero);
    }

}
