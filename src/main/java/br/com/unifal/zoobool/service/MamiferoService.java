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

}
