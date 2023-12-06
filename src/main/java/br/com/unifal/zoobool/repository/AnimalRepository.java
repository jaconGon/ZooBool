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

    @Query("SELECT g FROM Animal g ORDER BY g.nome DESC")
    List<Animal> orderAnimalZtoA();

    @Query("SELECT g FROM Animal g WHERE g.tamanho = 'Grande'")
    List<Animal> filtroTam();

    @Query("SELECT g FROM Animal g WHERE g.especie LIKE '%tartaruga%'")
    List<Animal> filtroTipo();
    
}
