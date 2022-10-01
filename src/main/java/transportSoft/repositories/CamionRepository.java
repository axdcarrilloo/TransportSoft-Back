package transportSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transportSoft.domain.entities.CamionEntity;

@Repository
public interface CamionRepository extends JpaRepository<CamionEntity, Long> {

}
