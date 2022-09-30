package transportSoft.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArmarMapResponse {
	
	private static Logger log = LoggerFactory.getLogger(ArmarMapResponse.class);
	
	public static String armarRegistroFallidoCliente(Map<String, Object> map) {
		log.info("ArmarMapResponse.class : armarRegistroFallidoCliente() -> Armando String en registro fallido");

			String response = "Error en el registro, campos vacios (";
			Integer maxCaracteres = response.length();
			
			if(map.get("tipoDocumento") != null) {
				response = response + map.get("tipoDocumento");
			}
			if(map.get("documento") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("documento");
				} else {
					response = response +", "+ map.get("documento");
				}
			}
			if(map.get("apellidos") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("apellidos");
				} else {
					response = response +", "+ map.get("apellidos");
				}
			}
			if(map.get("direccion") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("direccion");
				} else {
					response = response +", "+ map.get("direccion");
				}
			}
			if(map.get("correo") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("correo");
				} else {
					response = response +", "+ map.get("correo");
				}
			}
			if(map.get("telefono") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("telefono");
				} else {
					response = response +", "+ map.get("telefono");
				}
			}
			response = response + ")";
			return response;
	}

}
