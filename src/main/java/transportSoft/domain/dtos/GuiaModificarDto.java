package transportSoft.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GuiaModificarDto {
	
	private Long id;
	
	private String prefijo;
	
	private Integer consecutivo;
	
	private String descripcion;

}
