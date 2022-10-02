package transportSoft.domain.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import transportSoft.domain.entities.BodegaEntity;
import transportSoft.domain.entities.CamionEntity;
import transportSoft.domain.entities.ClienteEntity;
import transportSoft.domain.entities.ProductoEntity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaTerrestreRegistrarDto {
	
	private ProductoEntity producto;
	
	private CamionEntity camion;
	
	private BodegaEntity bodegaEntrega;
	
	private ClienteEntity cliente;
	
	private String prefijo;
	
	private String numeroGuia;
	
	private Float precioEnvio;
	
	private Integer cantidad;
	
	private Double descuento;
	
	private Double total;
	
	private LocalDateTime fechaRegistro;
	
	private LocalDateTime fechaEntrega;

}
