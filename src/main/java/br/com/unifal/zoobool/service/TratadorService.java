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

    public Tratador findById(Integer id){
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new TratadorNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Tratador add(Tratador tratador) {
        if(Objects.isNull(tratador) || Objects.isNull(tratador.getId_tratador())
                || Objects.isNull(tratador.getId_func()) || Objects.isNull(tratador.getTipo_func())
        ) {
            throw new InvalidTratadorException();
        }
        return repository.save(tratador);
    }

    public List<Tratador> findTratadoresWithHighSalary(){
        return repository.findTratadoresWithHighSalary();
    }

}