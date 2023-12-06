package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Ala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlaRepository extends JpaRepository<Ala, Integer> {
}
