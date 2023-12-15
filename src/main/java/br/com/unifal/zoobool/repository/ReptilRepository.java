package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Reptil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReptilRepository extends JpaRepository<Reptil, Integer> {


}
