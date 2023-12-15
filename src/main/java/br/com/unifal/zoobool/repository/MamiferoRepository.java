package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Mamifero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MamiferoRepository extends JpaRepository<Mamifero, Integer> {


}
