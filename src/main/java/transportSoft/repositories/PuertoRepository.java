package transportSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transportSoft.domain.entities.PuertoEntity;

@Repository
public interface PuertoRepository extends JpaRepository<PuertoEntity, Long> {

}
