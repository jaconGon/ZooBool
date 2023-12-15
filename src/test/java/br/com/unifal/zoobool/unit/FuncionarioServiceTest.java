package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Funcionario;
import br.com.unifal.zoobool.exception.FuncionarioNotFoundException;
import br.com.unifal.zoobool.exception.InvalidFuncionarioException;
import br.com.unifal.zoobool.repository.FuncionarioRepository;
import br.com.unifal.zoobool.service.FuncionarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {

    @InjectMocks
    private FuncionarioService service;

    @Mock
    private FuncionarioRepository repository;

    @Test
    @DisplayName("#findById > When the id is null > Throw an exception")
    void findByIdWhenTheIdIsNullThrowAnException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.findById(null));
    }
    @Test
    @DisplayName("#findById > When the id is not null > When a funcionario is found > Return the funcionario")
    void findByIdWhenTheIdIsNotNullWhenAFuncionarioIsFoundReturnTheAnimal() {
        when(repository.findById(1)).thenReturn(Optional.of(Funcionario.builder()
                .id_func(1)
                .pnome("João")
                .snome("Silva")
                .cpf("12345678901")
                .horas_trabalho(40)
                .salario(4000.00F)
                .telefone("(11) 1234-5678")
                .build()));
        Funcionario response = service.findById(1);
        assertAll(
                () -> assertEquals(1, response.getId_func()),
                () -> assertEquals("João", response.getPnome()),
                () -> assertEquals("Silva", response.getSnome()),
                () -> assertEquals("12345678901", response.getCpf()),
                () -> assertEquals(40, response.getHoras_trabalho()),
                () -> assertEquals(4000.00F, response.getSalario()),
                () -> assertEquals("(11) 1234-5678", response.getTelefone())
        );

    }

    @Test
    @DisplayName("#findById > When the id is not null > When no funcionario is found > Throw an exception")
    void findByIdWhenTheIdIsNotNullWhenNoFuncionarioIsFoundThrowAnException() {
        when(repository.findById(2)).thenReturn(Optional.empty());
        assertThrows(FuncionarioNotFoundException.class, () ->
                service.findById(2));
    }

    @Test
    @DisplayName("#deleteFuncionario > When the id is null > Throw an exception")
    void deleteFuncionarioWhenTheIdIsNullThrowException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteFuncionario(null));
    }


    @Test
    @DisplayName("#deleteFuncionario > When the id is not null but the funcionario doesnt exist > Throw an exception")
    void deleteFuncionarioWhenIdIsNotNullAndGuestDoesntExistThrowException() {
        when(repository.findById(1)).thenReturn(Optional.empty());
        assertThrows(FuncionarioNotFoundException.class, () -> service.deleteFuncionario(1));
    }

    @Test
    @DisplayName("#deleteFuncionario > When the animal exist > Delete the animal")
    void deleteByIdWhenTheFuncionarioExist() {
        when(repository.findById(1)).thenReturn(
                Optional.of(
                        Funcionario.builder().id_func(1).pnome("João").snome("Silva").cpf("12345678901").horas_trabalho(40).salario(4000.00F).telefone("(11) 1234-5678").build()
                )
        );
        Funcionario response = service.findById(1);
        assertAll(
                () -> assertEquals(1, response.getId_func()),
                () -> assertEquals("João", response.getPnome()),
                () -> assertEquals("Silva", response.getSnome()),
                () -> assertEquals("12345678901", response.getCpf()),
                () -> assertEquals(40, response.getHoras_trabalho()),
                () -> assertEquals(4000.00F, response.getSalario()),
                () -> assertEquals("(11) 1234-5678", response.getTelefone())

        );

        when(repository.findById(1)).thenReturn(Optional.empty());
        assertThrows(
                FuncionarioNotFoundException.class,
                () -> service.deleteFuncionario(response.getId_func())
        );
    }

    @Test
    @DisplayName("#saveFuncionario > When a funcionario is saved > Verify that the repository's save method is called")
    void saveFuncionarioWhenFuncionarioIsSavedVerifyRepositorySaveMethod() {
        Funcionario funcionario = Funcionario.builder().id_func(1).pnome("João").snome("Silva").cpf("12345678901").horas_trabalho(40).salario(4000.00F).telefone("(11) 1234-5678").build();
        service.saveFuncionario(funcionario);
        verify(repository, times(1)).save(funcionario);
    }

    @Test
    @DisplayName("#getAllFuncionarios > When there are no registered funcionario > Returns an empty list")
    void getAllFuncionariosWhenThereAreNoRegisteredFuncionariosReturnsAnEmptyList(){
        List<Funcionario> response = service.getAllFuncionarios();
        Assertions.assertTrue(response.isEmpty());
    }
    @Test
    @DisplayName("#getAllFuncionarios > When there are registered funcionario > Returns the list of funcionario")
    void getAllFuncionariosWhenThereAreRegisteredFuncionariosReturnsTheListOfFuncionarios(){
        when(service.getAllFuncionarios()).thenReturn(List.of(Funcionario.builder()
                .id_func(1)
                .pnome("João")
                .snome("Silva")
                .cpf("12345678901")
                .horas_trabalho(40)
                .salario(4000.00F)
                .telefone("(11) 1234-5678")
                .build()));
        List<Funcionario> response = service.getAllFuncionarios();
        assertAll(
                () -> assertEquals(1, response.get(0).getId_func()),
                () -> assertEquals("João", response.get(0).getPnome()),
                () -> assertEquals("Silva", response.get(0).getSnome()),
                () -> assertEquals("12345678901", response.get(0).getCpf()),
                () -> assertEquals(40, response.get(0).getHoras_trabalho()),
                () -> assertEquals(4000.00F, response.get(0).getSalario()),
                () -> assertEquals("(11) 1234-5678", response.get(0).getTelefone())


        );
    }

    @Test
    public void testAddFuncionarioWithValidData() {
        Funcionario funcionario = new Funcionario(1,"João", "Silva", "12345678901", 40, 4000.00F, "(11) 1234-5678");

        when(repository.save(funcionario)).thenReturn(funcionario);

        Funcionario result = service.add(funcionario);


        assertNotNull(result);
        assertEquals(funcionario, result);

        verify(repository, times(1)).save(funcionario);
    }

    @Test
    public void testAddFuncionarioWithInvalidData() {

        Funcionario funcionario = new Funcionario(1,"João", null, "12345678901", 40, 4000.00F, "(11) 1234-5678");

        assertThrows(InvalidFuncionarioException.class, () -> service.add(funcionario));

        verify(repository, never()).save(funcionario);
    }


}