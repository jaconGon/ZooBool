package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

    @Query("SELECT c FROM Veterinario c WHERE c.especialidade LIKE 'Mamíferos'")
    List<Veterinario> vetMamifero();

    @Query("SELECT v FROM Veterinario v WHERE " +
            "EXISTS (SELECT 1 FROM Funcionario f WHERE f.id_func = v.id_func AND f.horas_trabalho > 30)"
    )
    List<Veterinario> findVeterinariosWithHighWorkHours();

}