package br.com.unifal.zoobool.service;


import br.com.unifal.zoobool.entity.Veterinario;
import br.com.unifal.zoobool.exception.InvalidVeterinarioException;
import br.com.unifal.zoobool.repository.VeterinarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.unifal.zoobool.exception.VeterinarioNotFoundException;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class VeterinarioService {

    private final VeterinarioRepository repository;

    public List<Veterinario> getAllVeterinarios(){

        return repository.findAll();
    }

    public List<Veterinario> vetMamifero(){
        return repository.vetMamifero();
    }

    public List<Veterinario> findVeterinariosWithHighWorkHours(){
        return repository.findVeterinariosWithHighWorkHours();
    }

}