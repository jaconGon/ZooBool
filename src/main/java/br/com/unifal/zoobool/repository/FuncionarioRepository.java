package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query(
            "SELECT g FROM Funcionario g WHERE " +
                    "(:pnome is null OR UPPER(g.pnome) LIKE UPPER(concat('%', :pnome, '%'))) AND " +
                    "(:snome is null OR UPPER(g.snome) LIKE UPPER(concat('%', :snome, '%'))) AND " +
                    "(:cpf is null OR g.cpf LIKE concat('%', :cpf, '%'))"
    )
    List<Funcionario> findByFilter(String name, String last_name, String cpf);

}
