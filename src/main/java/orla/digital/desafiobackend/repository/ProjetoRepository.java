package orla.digital.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orla.digital.desafiobackend.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
