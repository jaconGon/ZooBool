package br.com.unifal.zoobool.service;


import br.com.unifal.zoobool.entity.Veterinario;
import br.com.unifal.zoobool.exception.InvalidVeterinarioException;
import br.com.unifal.zoobool.repository.VeterinarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.unifal.zoobool.exception.VeterinarioNotFoundException;
import java.util.List;
import br.com.unifal.zoobool.exception.InvalidTratadorException;
import java.util.Objects;


@AllArgsConstructor
@Service
public class VeterinarioService {

    private final VeterinarioRepository repository;

    public List<Veterinario> getAllHabitats(){

        return repository.findAll();
    }

    public Veterinario findById(Integer id){
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new VeterinarioNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Veterinario add(Veterinario veterinario) {
        if(Objects.isNull(veterinario) || Objects.isNull(veterinario.getId_vet())
                || Objects.isNull(veterinario.getId_func()) || Objects.isNull(veterinario.getEspecialidade())
                || Objects.isNull(veterinario.getDias_de_plantao())
        ) {
            throw new InvalidVeterinarioException();
        }
        return repository.save(veterinario);
    }

}