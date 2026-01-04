package desafio.api.repository;

import desafio.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiRepository extends JpaRepository<Produto, UUID> {
}