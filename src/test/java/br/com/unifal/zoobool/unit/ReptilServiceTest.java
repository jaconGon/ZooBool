package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Reptil;
import br.com.unifal.zoobool.repository.ReptilRepository;
import br.com.unifal.zoobool.service.ReptilService;
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
public class ReptilServiceTest {

    @InjectMocks
    private ReptilService service;

    @Mock
    private ReptilRepository repository;


    @Test
    @DisplayName("#getAllRepteis > When there are registered repteis > Returns the list of repteis")
    void getAllReptilsWhenThereAreRegisteredReptilsReturnsTheListOfReptils() {
        Reptil mamifero1 = new Reptil(1, "26 graus","90 dias");
        Reptil mamifero2 = new Reptil(6, "25 graus","180 dias");
        List<Reptil> repteis = Arrays.asList(mamifero1, mamifero2);

        when(repository.findAll()).thenReturn(repteis);


        List<Reptil> result = service.getAllRepteis();


        assertEquals(repteis.size(), result.size());
        assertEquals(repteis, result);

        verify(repository, times(1)).findAll();
    }
}