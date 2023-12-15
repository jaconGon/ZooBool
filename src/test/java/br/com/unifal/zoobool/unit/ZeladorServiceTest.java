package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Zelador;
import br.com.unifal.zoobool.repository.ZeladorRepository;
import br.com.unifal.zoobool.service.ZeladorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ZeladorServiceTest {

    @InjectMocks
    private ZeladorService service;

    @Mock
    private ZeladorRepository repository;


    @Test
    @DisplayName("#getAllZeladores > When there are registered zeladores > Returns the list of zeladores")
    void getAllZeladoresWhenThereAreRegisteredZeladorsReturnsTheListOfZeladors() {
        Zelador zelador1 = new Zelador(1, 1, "Zelador");
        Zelador zelador2 = new Zelador(2, 2, "Zelador");
        List<Zelador> zeladores = Arrays.asList(zelador1, zelador2);

        when(repository.findAll()).thenReturn(zeladores);


        List<Zelador> result = service.getAllZeladores();


        assertEquals(zeladores.size(), result.size());
        assertEquals(zeladores, result);

        verify(repository, times(1)).findAll();
    }
}