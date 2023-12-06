package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Reptil;
import br.com.unifal.zoobool.exception.ReptilNotFoundException;
import br.com.unifal.zoobool.exception.InvalidReptilException;
import br.com.unifal.zoobool.repository.ReptilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class ReptilService {

    private final ReptilRepository repository;

    public List<Reptil> getAllRepteis(){

        return repository.findAll();
    }

    public Reptil findById(Integer id){
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new ReptilNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Reptil add(Reptil reptil) {
        if(Objects.isNull(reptil) || Objects.isNull(reptil.getTempo_incubacao())
                || Objects.isNull(reptil.getTemperatura_corporal())  || Objects.isNull(reptil.getId_animal())
        ) {
            throw new InvalidReptilException();
        }
        return repository.save(reptil);
    }

}
