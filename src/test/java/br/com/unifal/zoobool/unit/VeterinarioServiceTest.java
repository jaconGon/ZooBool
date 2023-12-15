package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Veterinario;
import br.com.unifal.zoobool.repository.VeterinarioRepository;
import br.com.unifal.zoobool.service.VeterinarioService;
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
public class VeterinarioServiceTest {

    @InjectMocks
    private VeterinarioService service;

    @Mock
    private VeterinarioRepository repository;


    @Test
    @DisplayName("#getAllVeterinarios > When there are registered veterinarios > Returns the list of veterinarios")
    void getAllVeterinariosWhenThereAreRegisteredVeterinariosReturnsTheListOfVeterinarios() {
        Veterinario veterinario1 = new Veterinario(9, 1, "Segunda a Sexta", "Mamíferos");
        Veterinario veterinario2 = new Veterinario(10, 2, "Sábado e Domingo", "Répteis");
        List<Veterinario> veterinarios = Arrays.asList(veterinario1, veterinario2);

        when(repository.findAll()).thenReturn(veterinarios);


        List<Veterinario> result = service.getAllVeterinarios();


        assertEquals(veterinarios.size(), result.size());
        assertEquals(veterinarios, result);

        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("#findVeterinariosWithHighWorkHours > When there are registered veterinarios > Returns the list of veterinarios")
    public void testFindVeterinariosWithHighWorkHoursWhenThereAreRegisteredVeterinariosReturnsTheListOfVeterinarios() {
        Veterinario veterinario1 = new Veterinario(9, 1,"Segunda a Sexta", "Mamíferos");
        Veterinario veterinario2 = new Veterinario(10, 2,"Sábado e Domingo", "Répteis");
        List<Veterinario> veterinarios = Arrays.asList(veterinario1, veterinario2);

        when(repository.findVeterinariosWithHighWorkHours()).thenReturn(veterinarios);

        List<Veterinario> result = service.findVeterinariosWithHighWorkHours();


        assertEquals(veterinarios.size(), result.size());
        assertEquals(veterinarios, result);

        verify(repository, times(1)).findVeterinariosWithHighWorkHours();
    }

    @Test
    @DisplayName("#vetMamifero > When there are registered veterinarios > Returns the list of veterinarios")
    public void testVetMamiferoWhenThereAreRegisteredVeterinariosReturnsTheListOfVeterinarios() {
        Veterinario veterinario1 = new Veterinario(9, 1, "Segunda a Sexta", "Mamíferos");
        Veterinario veterinario2 = new Veterinario(10, 2, "Sábado e Domingo", "Répteis");
        List<Veterinario> veterinarios = Arrays.asList(veterinario1, veterinario2);

        when(repository.vetMamifero()).thenReturn(veterinarios);

        List<Veterinario> result = service.vetMamifero();


        assertEquals(veterinarios.size(), result.size());
        assertEquals(veterinarios, result);

        verify(repository, times(1)).vetMamifero();
    }

}