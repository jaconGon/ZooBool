package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Ala;
import br.com.unifal.zoobool.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlaRepository extends JpaRepository<Ala, Integer> {

    @Query("SELECT g FROM Ala g ORDER BY g.tamanho ASC")
    List<Funcionario> orderAlaAtoZ();}
