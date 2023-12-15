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

    @Query("SELECT g FROM Animal g WHERE g.nome LIKE '%na%'")
    List<Animal> filtroNome();

    @Query("SELECT g FROM Animal g WHERE g.tamanho = 'Pequeno' " +
            "UNION SELECT p FROM Animal p WHERE p.id_habitat = 43")
    List<Animal> filtroHabPe();

    @Query("select g from Animal g where g.id_vet = 1 " +
            "UNION select p from Animal p where p.peso = 30")
    List<Animal> filtroVetPe();

    @Query("SELECT a FROM Animal a JOIN Mamifero m ON a.id_animal = m.id_animal")
    List<Animal> findAnimaisComMamiferos();



}
