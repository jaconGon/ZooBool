package br.com.unifal.zoobool.service;


import br.com.unifal.zoobool.entity.Habitat;
import br.com.unifal.zoobool.repository.HabitatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.unifal.zoobool.exception.HabitatNotFoundException;
import java.util.List;
import br.com.unifal.zoobool.exception.InvalidHabitatException;
import java.util.Objects;


@AllArgsConstructor
@Service
public class HabitatService {

    private final HabitatRepository repository;

    public List<Habitat> getAllHabitats(){

        return repository.findAll();
    }

    public Habitat findById(Integer id){
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new HabitatNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Habitat add(Habitat habitat) {
        if(Objects.isNull(habitat) || Objects.isNull(habitat.getId_habitat())
                || Objects.isNull(habitat.getTipo()) || Objects.isNull(habitat.getHorario_trat())
                || Objects.isNull(habitat.getId_tratador()) || Objects.isNull(habitat.getN_especies())
                || Objects.isNull(habitat.getId_ala())
        ) {
            throw new InvalidHabitatException();
        }
        return repository.save(habitat);
    }

}
