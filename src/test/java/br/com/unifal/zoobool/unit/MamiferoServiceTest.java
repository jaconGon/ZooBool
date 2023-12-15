package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Mamifero;
import br.com.unifal.zoobool.repository.MamiferoRepository;
import br.com.unifal.zoobool.service.MamiferoService;
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
public class MamiferoServiceTest {

    @InjectMocks
    private MamiferoService service;

    @Mock
    private MamiferoRepository repository;


    @Test
    @DisplayName("#getAllMamiferos > When there are registered mamiferos > Returns the list of mamiferos")
    void getAllMamiferosWhenThereAreRegisteredMamiferosReturnsTheListOfMamiferos() {
        Mamifero mamifero1 = new Mamifero(2, "110 dias","90 dias");
        Mamifero mamifero2 = new Mamifero(2, "63 dias","6 meses");
        List<Mamifero> mamiferos = Arrays.asList(mamifero1, mamifero2);

        when(repository.findAll()).thenReturn(mamiferos);


        List<Mamifero> result = service.getAllMamiferos();


        assertEquals(mamiferos.size(), result.size());
        assertEquals(mamiferos, result);

        verify(repository, times(1)).findAll();
    }
}