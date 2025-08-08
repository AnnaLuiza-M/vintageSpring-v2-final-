package vintage.spring.store.vintage_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vintage.spring.store.vintage_spring.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
