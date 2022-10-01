package transportSoft.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import transportSoft.domain.entities.GuiaEntity;
import transportSoft.utils.ConstantesSQL;

@Repository
public interface GuiaRepository extends JpaRepository<GuiaEntity, Long> {
	
	Optional<GuiaEntity> findByPrefijo(String prefijo);
	
	@Transactional
	@Modifying
	@Query(value = ConstantesSQL.MODIFICAR_GUIA, nativeQuery = true)
	void modificarTodo(@Param("id")Long id, @Param("prefijo")String prefijo, @Param("consecutivo")Integer consecutivo,
			@Param("descripcion")String descripcion);

}
