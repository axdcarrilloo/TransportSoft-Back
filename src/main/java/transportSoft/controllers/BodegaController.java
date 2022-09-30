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

import transportSoft.domain.dtos.BodegasRegistrarDto;
import transportSoft.domain.dtos.ResponseMainDto;
import transportSoft.services.BodegaService;
import transportSoft.utils.ArmarMapResponse;
import transportSoft.utils.Constantes;
import transportSoft.utils.Route;

@RestController
@RequestMapping(value = Route.BASE+Route.BODEGA, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BodegaController {
	
	@Autowired
	private BodegaService bodegaSvc;
	
	@DeleteMapping(value = Route.ELIMINAR)
	public ResponseEntity<ResponseMainDto> eliminar(@PathVariable String id) {
		Long idResponse = bodegaSvc.eliminar(Long.parseLong(id));
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
				(Constantes.ESTADO_CONSULTA_EXITOSA, bodegaSvc.consultarTodas()), HttpStatus.OK);
	}
	
	@PostMapping(value = Route.REGISTRAR)
	public ResponseEntity<ResponseMainDto> registrar(@RequestBody BodegasRegistrarDto bodega) {
		Map<String, Object> map = bodegaSvc.registrar(bodega);
		if(map.get("response") != null) {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_EXITOSO, 
					(Long)map.get("response")), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_FALLIDO, 
					ArmarMapResponse.armarRegistroFallidoBodega(map)), HttpStatus.BAD_REQUEST);
		}
	}

}
