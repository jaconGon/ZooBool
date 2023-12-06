package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Animal;
import br.com.unifal.zoobool.entity.Funcionario;
import br.com.unifal.zoobool.exception.AnimalNotFoundException;
import br.com.unifal.zoobool.exception.FuncionarioNotFoundException;
import br.com.unifal.zoobool.exception.InvalidAnimalException;
import br.com.unifal.zoobool.exception.InvalidFuncionarioException;
import br.com.unifal.zoobool.repository.AnimalRepository;
import br.com.unifal.zoobool.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@AllArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public List<Funcionario> getAllFuncionarios() {
        return repository.findAll();
    }

    public Funcionario findById(Integer id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
                new FuncionarioNotFoundException(
                        String.format("No user found for id %d", id))
        );
    }

    public Funcionario add(Funcionario funcionario) {
        if (Objects.isNull(funcionario) || Objects.isNull(funcionario.getId_func())
                || Objects.isNull(funcionario.getPnome()) || Objects.isNull(funcionario.getSnome())
                || Objects.isNull(funcionario.getCpf()) || Objects.isNull(funcionario.getHoras_trabalho())
                || Objects.isNull(funcionario.getSalario()) || Objects.isNull(funcionario.getTelefone())
        ) {
            throw new InvalidFuncionarioException();
        }
        return repository.save(funcionario);
    }

    public void saveFuncionario(Funcionario funcionario) {
        repository.save(funcionario);
    }

    public void deleteFuncionario(Integer id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if (funcionario.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new FuncionarioNotFoundException(String.format("User with id[%d] not found!!", id));
        }
    }
}

