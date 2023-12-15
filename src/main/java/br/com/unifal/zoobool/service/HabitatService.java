package br.com.unifal.zoobool.service;


import br.com.unifal.zoobool.entity.Habitat;
import br.com.unifal.zoobool.repository.HabitatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.unifal.zoobool.exception.HabitatNotFoundException;
import java.util.List;
import br.com.unifal.zoobool.exception.InvalidHabitatException;
import java.util.Objects;


@AllArgsConstructor
@Service
public class HabitatService {

    private final HabitatRepository repository;


}
