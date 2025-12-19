package desafio.api.repository;

import desafio.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Produto, Long> {
}