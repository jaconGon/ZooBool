package br.com.unifal.zoobool.service;


import br.com.unifal.zoobool.entity.Zelador;
import br.com.unifal.zoobool.exception.InvalidZeladorException;
import br.com.unifal.zoobool.repository.ZeladorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.unifal.zoobool.exception.ZeladorNotFoundException;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class ZeladorService {

    private final ZeladorRepository repository;

    public List<Zelador> getAllZeladores(){

        return repository.findAll();
    }


}