package transportSoft.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import transportSoft.domain.dtos.FlotaRegistrarDto;
import transportSoft.domain.dtos.ResponseMainDto;
import transportSoft.services.FlotaService;
import transportSoft.utils.ArmarMapResponse;
import transportSoft.utils.Constantes;
import transportSoft.utils.Route;

@RestController
@RequestMapping(value = Route.BASE+Route.FLOTA, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class FlotaController {
	
	@Autowired
	private FlotaService flotaSvc;
	
	@DeleteMapping(value = Route.ELIMINAR)
	public ResponseEntity<ResponseMainDto> eliminar(@PathVariable String id) {
		Long idResponse = flotaSvc.eliminar(Long.parseLong(id));
		if(idResponse != null) {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto
					(Constantes.ESTADO_ELIMINACION_EXITOSA, idResponse), HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto
					(Constantes.ESTADO_ELIMINACION_FALLIDA, Constantes.ESTADO_NOEXISTE), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = Route.TODAS)
	public ResponseEntity<ResponseMainDto> consultarTodas() {
		return new ResponseEntity<ResponseMainDto>(new ResponseMainDto
				(Constantes.ESTADO_CONSULTA_EXITOSA, flotaSvc.consultarTodas()), HttpStatus.OK);
	}
	
	@PostMapping(value = Route.REGISTRAR)
	public ResponseEntity<ResponseMainDto> registrar(@RequestBody FlotaRegistrarDto flota) {
		Map<String, Object> map = flotaSvc.registrar(flota);
		if(map.get("numeroLength") != null) {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_FALLIDO, 
					(String)map.get("numeroLength")), HttpStatus.BAD_REQUEST);
		}
		if(map.get("response") != null) {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_EXITOSO, 
					(Long)map.get("response")), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_FALLIDO, 
					ArmarMapResponse.armarRegistroFallidoFlota(map)), HttpStatus.BAD_REQUEST);
		}
	}

}
