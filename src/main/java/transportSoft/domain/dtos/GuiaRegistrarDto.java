package transportSoft.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GuiaRegistrarDto {
	
	private String prefijo;
	
	private Integer consecutivo;
	
	private String descripcion;

}
