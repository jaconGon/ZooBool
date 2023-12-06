package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Ala;
import br.com.unifal.zoobool.entity.Funcionario;
import br.com.unifal.zoobool.exception.FuncionarioNotFoundException;
import br.com.unifal.zoobool.exception.InvalidFuncionarioException;
import br.com.unifal.zoobool.repository.AlaRepository;
import br.com.unifal.zoobool.repository.FuncionarioRepository;
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
