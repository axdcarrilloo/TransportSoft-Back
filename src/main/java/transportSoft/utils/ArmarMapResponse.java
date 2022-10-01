package transportSoft.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArmarMapResponse {
	
	private static Logger log = LoggerFactory.getLogger(ArmarMapResponse.class);
	
	public static String armarRegistroFallidoEntregaTerrestre(Map<String, Object> map) {
		log.info("ArmarMapResponse.class : armarRegistroFallidoEntregaTerrestre() -> Armando String en registro fallido");

			String response = "Error en el registro, campos vacios (";
			Integer maxCaracteres = response.length();
			
			if(map.get("producto") != null) {
				response = response + map.get("producto");
			}
			if(map.get("camion") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("camion");
				} else {
					response = response +", "+ map.get("camion");
				}
			}
			if(map.get("bodegaEntrega") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("bodegaEntrega");
				} else {
					response = response +", "+ map.get("bodegaEntrega");
				}
			}
			if(map.get("cliente") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("cliente");
				} else {
					response = response +", "+ map.get("cliente");
				}
			}
			if(map.get("numeroGuia") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("numeroGuia");
				} else {
					response = response +", "+ map.get("numeroGuia");
				}
			}
			if(map.get("precioEnvio") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("precioEnvio");
				} else {
					response = response +", "+ map.get("precioEnvio");
				}
			}
			if(map.get("cantidad") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("cantidad");
				} else {
					response = response +", "+ map.get("cantidad");
				}
			}
			if(map.get("fechaRegistro") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("fechaRegistro");
				} else {
					response = response +", "+ map.get("fechaRegistro");
				}
			}
			if(map.get("fechaEntrega") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("fechaEntrega");
				} else {
					response = response +", "+ map.get("fechaEntrega");
				}
			}
			response = response + ")";
			return response;
	}
	
	public static String armarRegistroFallidoFlota(Map<String, Object> map) {
		log.info("ArmarMapResponse.class : armarRegistroFallidoBodega() -> Armando String en registro fallido");

			String response = "Error en el registro, campos vacios (";
			Integer maxCaracteres = response.length();
			
			if(map.get("numero") != null) {
				response = response + map.get("numero");
			}
			if(map.get("capitan") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("capitan");
				} else {
					response = response +", "+ map.get("capitan");
				}
			}
			response = response + ")";
			return response;
	}
	
	public static String armarRegistroFallidoCamion(Map<String, Object> map) {
		log.info("ArmarMapResponse.class : armarRegistroFallidoBodega() -> Armando String en registro fallido");

			String response = "Error en el registro, campos vacios (";
			Integer maxCaracteres = response.length();
			
			if(map.get("placa") != null) {
				response = response + map.get("placa");
			}
			if(map.get("conductor") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("conductor");
				} else {
					response = response +", "+ map.get("conductor");
				}
			}
			response = response + ")";
			return response;
	}
	
	public static String armarRegistroFallidoProducto(Map<String, Object> map) {
		log.info("ArmarMapResponse.class : armarRegistroFallidoBodega() -> Armando String en registro fallido");

			String response = "Error en el registro, campos vacios (";
			Integer maxCaracteres = response.length();
			
			if(map.get("tipoProducto") != null) {
				response = response + map.get("tipoProducto");
			}
			if(map.get("nombre") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("nombre");
				} else {
					response = response +", "+ map.get("nombre");
				}
			}
			if(map.get("tipoTransporte") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("tipoTransporte");
				} else {
					response = response +", "+ map.get("tipoTransporte");
				}
			}
			response = response + ")";
			return response;
	}
	
	public static String armarRegistroFallidoBodega(Map<String, Object> map) {
		log.info("ArmarMapResponse.class : armarRegistroFallidoBodega() -> Armando String en registro fallido");

			String response = "Error en el registro, campos vacios (";
			Integer maxCaracteres = response.length();
			
			if(map.get("nombre") != null) {
				response = response + map.get("nombre");
			}
			if(map.get("direccion") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("direccion");
				} else {
					response = response +", "+ map.get("direccion");
				}
			}
			if(map.get("ciudad") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("ciudad");
				} else {
					response = response +", "+ map.get("ciudad");
				}
			}
			response = response + ")";
			return response;
	}
	
	public static String armarRegistroFallidoPuerto(Map<String, Object> map) {
		log.info("ArmarMapResponse.class : armarRegistroFallidoCliente() -> Armando String en registro fallido");

			String response = "Error en el registro, campos vacios (";
			Integer maxCaracteres = response.length();
			
			if(map.get("nombre") != null) {
				response = response + map.get("nombre");
			}
			if(map.get("direccion") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("direccion");
				} else {
					response = response +", "+ map.get("direccion");
				}
			}
			if(map.get("ciudad") != null) {
				if(response.length() == maxCaracteres) {
					response = response + map.get("ciudad");
				} else {
					response = response +", "+ map.get("ciudad");
				}
			}
			response = response + ")";
			return response;
	}
	
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
