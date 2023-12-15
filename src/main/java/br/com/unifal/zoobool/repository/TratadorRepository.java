package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Tratador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TratadorRepository extends JpaRepository<Tratador, Integer> {

    @Query("SELECT c FROM Tratador c WHERE " +
            "EXISTS (SELECT q FROM Funcionario q WHERE q.id_func = c.id_func AND q.salario > 3400)"
    )
    List<Tratador> findTratadoresWithHighSalary();


}