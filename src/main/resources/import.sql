
/* Guias para las entradas */
INSERT INTO `guias` (`id`, `consecutivo`, `descripcion`, `prefijo`) VALUES (NULL, '1', 'Guia para entregas terrestres', 'PENT');
INSERT INTO `guias` (`id`, `consecutivo`, `descripcion`, `prefijo`) VALUES (NULL, '1', 'Guia para entregas maritimas', 'PENM');

/* Bodega */
INSERT INTO `bodegas` (`id`, `ciudad`, `direccion`, `nombre`) VALUES (NULL, 'Manizales', 'Manzana 128-08b', 'Lanzada');

/* Camion */
INSERT INTO `camiones` (`id`, `conductor`, `descripcion`, `placa`) VALUES (NULL, 'Ernesto Camacho', 'Mazda 2030', 'QAZ-321');

/* Cliente */
INSERT INTO `clientes` (`id`, `apellidos`, `ciudad`, `correo`, `direccion`, `documento`, `nombres`, `telefono`, `tipo_documento`) VALUES (NULL, 'Joly Pit', 'Buenos Aires', 'bjl02@prueba.com', 'Barrio esmeralda 23c-56', '1245565745', 'Brandon Enrrique', '3119453', 'CC');

/* Flota */
INSERT INTO `flotas` (`id`, `capitan`, `descripcion`, `numero`) VALUES (NULL, 'Deiby Jhoms', 'El Holandes Herrante', 'EAX-091H');

/* Producto */
INSERT INTO `productos` (`id`, `nombre`, `tipo_producto`, `tipo_transporte`) VALUES (NULL, 'Cama', 'Dormitorio', 'T');
INSERT INTO `productos` (`id`, `nombre`, `tipo_producto`, `tipo_transporte`) VALUES (NULL, 'Maquina Rayos X', 'Enfermeria', 'M');

/* Puerto */
INSERT INTO `puertos` (`id`, `ciudad`, `direccion`, `nombre`) VALUES (NULL, 'Buenos Aires', 'Lincon 38-01', 'Salvador');
INSERT INTO `puertos` (`id`, `ciudad`, `direccion`, `nombre`) VALUES (NULL, 'Armenia', 'Barrio La Paz', 'La Consusmada');




