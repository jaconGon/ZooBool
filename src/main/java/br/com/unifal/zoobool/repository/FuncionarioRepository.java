package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT g FROM Funcionario g ORDER BY g.pnome ASC")
    List<Funcionario> orderFuncionarioAtoZ();

    @Query("SELECT g FROM Funcionario g ORDER BY g.pnome DESC")
    List<Funcionario> orderFuncionariosZtoA();

    @Query("SELECT g FROM Funcionario g ORDER BY g.id_func DESC")
    List<Funcionario> funcionarioIdDesc();
}

