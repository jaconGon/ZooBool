package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Manutencao;
import br.com.unifal.zoobool.repository.ManutencaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ManutencaoService {

    private final ManutencaoRepository repository;

    public List<Manutencao> getAllManutencoes(){

        return repository.findAll();
    }

}
