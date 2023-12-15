package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Ala;
import br.com.unifal.zoobool.entity.Animal;
import br.com.unifal.zoobool.repository.AlaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class AlaService {

    private final AlaRepository repository;

    public List<Ala> getAllAlas(){

        return repository.findAll();
    }

}
