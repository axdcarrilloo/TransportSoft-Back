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

import transportSoft.domain.dtos.CamionRegistrarDto;
import transportSoft.domain.dtos.ResponseMainDto;
import transportSoft.services.CamionService;
import transportSoft.utils.ArmarMapResponse;
import transportSoft.utils.Constantes;
import transportSoft.utils.Route;

@RestController
@RequestMapping(value = Route.BASE+Route.CAMION, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CamionController {
	
	@Autowired
	private CamionService camionSvc;
	
	@DeleteMapping(value = Route.ELIMINAR)
	public ResponseEntity<ResponseMainDto> eliminar(@PathVariable String id) {
		Long idResponse = camionSvc.eliminar(Long.parseLong(id));
		if(idResponse != null) {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto
					(Constantes.ESTADO_ELIMINACION_EXITOSA, idResponse), HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto
					(Constantes.ESTADO_ELIMINACION_FALLIDA, Constantes.ESTADO_NOEXISTE), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = Route.TODOS)
	public ResponseEntity<ResponseMainDto> consultarTodos() {
		return new ResponseEntity<ResponseMainDto>(new ResponseMainDto
				(Constantes.ESTADO_CONSULTA_EXITOSA, camionSvc.consultarTodos()), HttpStatus.OK);
	}
	
	@PostMapping(value = Route.REGISTRAR)
	public ResponseEntity<ResponseMainDto> registrar(@RequestBody CamionRegistrarDto camion) {
		Map<String, Object> map = camionSvc.registrar(camion);
		if(map.get("placaLength") != null) {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_FALLIDO, 
					(String)map.get("placaLength")), HttpStatus.BAD_REQUEST);
		}
		if(map.get("response") != null) {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_EXITOSO, 
					(Long)map.get("response")), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ResponseMainDto>(new ResponseMainDto(Constantes.ESTADO_REGISTRO_FALLIDO, 
					ArmarMapResponse.armarRegistroFallidoCamion(map)), HttpStatus.BAD_REQUEST);
		}
	}

}
