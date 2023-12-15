package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Tratador;
import br.com.unifal.zoobool.repository.TratadorRepository;
import br.com.unifal.zoobool.service.TratadorService;
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
public class TratadorServiceTest {

    @InjectMocks
    private TratadorService service;

    @Mock
    private TratadorRepository repository;


    @Test
    @DisplayName("#getAllTratadores > When there are registered tratadores > Returns the list of tratadores")
    void getAllTratadorsWhenThereAreRegisteredTratadoresReturnsTheListOfTratadors() {
        Tratador tratador1 = new Tratador(5, 1,"Tratador");
        Tratador tratador2 = new Tratador(6, 2,"Tratador");
        List<Tratador> tratadores = Arrays.asList(tratador1, tratador2);

        when(repository.findAll()).thenReturn(tratadores);


        List<Tratador> result = service.getAllTratadores();


        assertEquals(tratadores.size(), result.size());
        assertEquals(tratadores, result);

        verify(repository, times(1)).findAll();
    }


    @Test
    @DisplayName("#findTratadoresWithHightSalary > When there are registered tratadores > Returns the list of tratadores")
    public void testFindTratadoresWithHighSalaryWhenThereAreRegisteredTratadoresReturnsTheListOfTratadores() {
        Tratador tratador1 = new Tratador(5, 1,"Tratador");
        Tratador tratador2 = new Tratador(6, 2,"Tratador");
        List<Tratador> tratadores = Arrays.asList(tratador1, tratador2);

        when(repository.findTratadoresWithHighSalary()).thenReturn(tratadores);

        List<Tratador> result = service.findTratadoresWithHighSalary();


        assertEquals(tratadores.size(), result.size());
        assertEquals(tratadores, result);

        verify(repository, times(1)).findTratadoresWithHighSalary();
    }
}