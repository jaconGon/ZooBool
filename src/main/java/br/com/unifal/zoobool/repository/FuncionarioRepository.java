package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
