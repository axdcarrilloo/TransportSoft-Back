package transportSoft.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import transportSoft.domain.entities.ClienteEntity;
import transportSoft.utils.ConstantesSQL;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	@Transactional
	@Modifying
	@Query(value = ConstantesSQL.MODIFICAR_CLIENTE, nativeQuery = true)
	void modificarTodo(@Param("id")Long id, @Param("tipoDocumento")String tipoDocumento, 
			@Param("documento")String documento, @Param("nombres")String nombres, @Param("apellidos")String apellidos, 
			@Param("direccion")String direccion, @Param("ciudad")String ciudad, @Param("correo")String correo, 
			@Param("telefono")String telefono);
		
	
	Optional<ClienteEntity> findByDocumento(String documento);

}
