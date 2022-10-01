package transportSoft.domain.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import transportSoft.domain.entities.ClienteEntity;
import transportSoft.domain.entities.FlotaEntity;
import transportSoft.domain.entities.ProductoEntity;
import transportSoft.domain.entities.PuertoEntity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaMaritimaRegistrarDto {
	
	private ProductoEntity producto;
	
	private FlotaEntity flota;
	
	private PuertoEntity puertoEntrega;
	
	private ClienteEntity cliente;
	
	private String numeroGuia;
	
	private Float precioEnvio;
	
	private Integer cantidad;
	
	private LocalDateTime fechaRegistro;
	
	private LocalDateTime fechaEntrega;

}
