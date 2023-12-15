package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Ala;
import br.com.unifal.zoobool.repository.AlaRepository;
import br.com.unifal.zoobool.service.AlaService;
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
public class AlaServiceTest {

    @InjectMocks
    private AlaService service;

    @Mock
    private AlaRepository repository;


    @Test
    @DisplayName("#getAllAlas > When there are registered alas > Returns the list of alas")
    void getAllAlasWhenThereAreRegisteredAlasReturnsTheListOfAlas() {
        Ala ala1 = new Ala(1, "Pequena");
        Ala ala2 = new Ala(2, "Média");
        List<Ala> alas = Arrays.asList(ala1, ala2);

        when(repository.findAll()).thenReturn(alas);


        List<Ala> result = service.getAllAlas();


        assertEquals(alas.size(), result.size());
        assertEquals(alas, result);

        verify(repository, times(1)).findAll();
    }
}



