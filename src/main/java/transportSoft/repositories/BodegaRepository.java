package transportSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transportSoft.domain.entities.BodegaEntity;

@Repository
public interface BodegaRepository extends JpaRepository<BodegaEntity, Long>{

}
