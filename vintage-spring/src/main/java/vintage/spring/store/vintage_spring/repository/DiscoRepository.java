package vintage.spring.store.vintage_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vintage.spring.store.vintage_spring.entities.Disco;

public interface DiscoRepository extends JpaRepository<Disco, Long> {
}
