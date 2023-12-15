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


}
