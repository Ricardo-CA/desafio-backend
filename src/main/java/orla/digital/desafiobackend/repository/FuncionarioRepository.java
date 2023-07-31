package orla.digital.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orla.digital.desafiobackend.entity.Funcionario;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public Optional<Funcionario> findByCpf(String cpf);

}
