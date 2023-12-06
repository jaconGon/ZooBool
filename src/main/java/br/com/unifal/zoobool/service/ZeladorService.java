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

    public Zelador findById(Integer id){
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new ZeladorNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Zelador add(Zelador zelador) {
        if(Objects.isNull(zelador) || Objects.isNull(zelador.getId_zelador())
                || Objects.isNull(zelador.getId_func()) || Objects.isNull(zelador.getTipo_func())
        ) {
            throw new InvalidZeladorException();
        }
        return repository.save(zelador);
    }

}