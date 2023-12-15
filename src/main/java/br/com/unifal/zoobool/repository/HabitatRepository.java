package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Integer> {


}
