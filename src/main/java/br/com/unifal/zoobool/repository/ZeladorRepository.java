package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Zelador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZeladorRepository extends JpaRepository<Zelador, Integer> {


}