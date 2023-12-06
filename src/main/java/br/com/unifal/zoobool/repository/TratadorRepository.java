package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Tratador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratadorRepository extends JpaRepository<Tratador, Integer> {


}