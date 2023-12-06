package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Integer> {
}
