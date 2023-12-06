package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Zelador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZeladorRepository extends JpaRepository<Zelador, Integer> {

    @Query("SELECT c FROM Zelador c WHERE " +
            "EXISTS (SELECT q FROM Funcionario q WHERE q.id_func = c.id_func AND q.salario > 3500)"
    )
    List<Zelador> findZeladoresWithHighSalary();


}