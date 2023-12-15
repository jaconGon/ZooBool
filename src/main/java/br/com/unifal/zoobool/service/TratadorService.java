package br.com.unifal.zoobool.service;


import br.com.unifal.zoobool.entity.Tratador;
import br.com.unifal.zoobool.repository.TratadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.unifal.zoobool.exception.TratadorNotFoundException;
import java.util.List;
import br.com.unifal.zoobool.exception.InvalidTratadorException;
import java.util.Objects;


@AllArgsConstructor
@Service
public class TratadorService {

    private final TratadorRepository repository;

    public List<Tratador> getAllTratadores(){

        return repository.findAll();
    }

    public List<Tratador> findTratadoresWithHighSalary(){
        return repository.findTratadoresWithHighSalary();
    }
//
}