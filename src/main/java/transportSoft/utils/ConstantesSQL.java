package transportSoft.utils;

public class ConstantesSQL {
	
	public static final String MODIFICAR_CLIENTE = "UPDATE `clientes` SET `tipo_documento` = :tipoDocumento, `documento` = :documento, "
			+ "`nombres` = :nombres, `apellidos` = :apellidos, `direccion` = :direccion, `ciudad` = :ciudad, `correo` = :correo, `telefono` = :telefono "
			+ "WHERE `clientes`.`id` = :id";

}
