package transportSoft.utils;

import java.time.LocalDateTime;

public class Constantes {
	
	public static final Long SI_EXISTENCIA = -1L; // Validador de existencia de objeto
	
//	Estados de peticiones
	public static final String ESTADO_SIEXISTE = "Si Existe";
	public static final String ESTADO_REGISTRO_FALLIDO = "Registro Fallido";
	public static final String ESTADO_REGISTRO_EXITOSO = "Registro Exitoso";
	public static final String ESTADO_CONSULTA_EXITOSA = "Consulta Exitosa";
	public static final String ESTADO_CONSULTA_FALLIDA = "Consulta Fallida";
	public static final String ESTADO_ELIMINACION_EXITOSA = "Eliminacion Exitosa";
	public static final String ESTADO_ELIMINACION_FALLIDA = "Eliminacion Fallida";
	public static final String ESTADO_NOEXISTE = "No Existe";
	public static final String ESTADO_MODIFICACION_EXITOSA = "Modificacion Exitosa";
	public static final String ESTADO_MODIFICACION_FALLIDA = "Modificacion Fallida";
	
	public static final String DUPLICIDAD_REGISTRO = "Ya se encuentra registrado";
	public static final String ERROR_CARACTERES_PREFIJO = "Error en los caracteres del prefijo";
	public static final String INEXISTENCIA_PRODUCTO = "No se encontro el producto";
	public static final String INEXISTENCIA_CAMION = "No se encontro el camion";
	public static final String INEXISTENCIA_FLOTA = "No se encontro la flota";
	public static final String INEXISTENCIA_BODEGA = "No se encontro la bodega";
	public static final String INEXISTENCIA_PUERTO = "No se encontro el puerto";
	public static final String INEXISTENCIA_CLIENTE = "No se encontro el cliente";
	public static final String ERROR_CARACTERES_PLACA = "Error en los caracteres de la placa";
	public static final String ERROR_CARACTERES_NUMERO = "Error en los caracteres del numero de flota";
	
//	Prefijos de las entregas
	public static final String PREFIJO_ENTREGA_T = "PENT";
	public static final String PREFIJO_ENTREGA_M = "PENM";
	
	public static final String DESCRIPCION_ENTREGA_T = "Guia para entregas terrestres";
	public static final String DESCRIPCION_ENTREGA_M = "Guia para entregas maritimas";
	
	public static LocalDateTime obtenerFechaActual() {
		return LocalDateTime.now();
	} 
	
	public static Boolean validarLetra(String letras) {
		 return letras.matches("[A-Z]+");
	}
	
	public static Boolean validarNumero(String numero) {
		 return numero.matches("[0-9]+");
	}

}
