package transportSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transportSoft.domain.entities.FlotaEntity;

@Repository
public interface FlotaRepository extends JpaRepository<FlotaEntity, Long> {

}
