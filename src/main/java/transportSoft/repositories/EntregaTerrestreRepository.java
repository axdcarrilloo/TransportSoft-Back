package transportSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transportSoft.domain.entities.EntregaTerrestreEntity;

@Repository
public interface EntregaTerrestreRepository extends JpaRepository<EntregaTerrestreEntity, Long> {

}
