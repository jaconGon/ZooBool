package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT g FROM Animal g ORDER BY g.nome ASC")
    List<Animal> orderAnimalAtoZ();
}
