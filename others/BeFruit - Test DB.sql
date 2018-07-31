-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: BeFruit
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DetallesFactura`
--

DROP TABLE IF EXISTS `DetallesFactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DetallesFactura` (
  `idDetalleFactura` bigint(20) unsigned NOT NULL,
  `idTipoFactura` bigint(20) unsigned NOT NULL,
  `idNumericoSucursal` bigint(20) unsigned NOT NULL,
  `idNumericoFactura` bigint(20) unsigned NOT NULL,
  `idProducto` bigint(20) unsigned DEFAULT NULL,
  `idPromocion` bigint(20) unsigned DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` decimal(2,0) NOT NULL,
  PRIMARY KEY (`idDetalleFactura`,`idTipoFactura`,`idNumericoSucursal`,`idNumericoFactura`),
  KEY `idProducto_idx` (`idProducto`),
  KEY `idPromocion_idx` (`idPromocion`),
  KEY `idNumericoFactura_idx` (`idNumericoFactura`),
  KEY `idNumericoSucursal_idx` (`idNumericoSucursal`),
  KEY `idTipoFactura_idx` (`idTipoFactura`),
  CONSTRAINT `DFactura_Facturas_idNumericoFactura` FOREIGN KEY (`idNumericoFactura`) REFERENCES `Facturas` (`idTipoFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DFactura_Facturas_idNumericoSucursal` FOREIGN KEY (`idNumericoSucursal`) REFERENCES `Facturas` (`idTipoFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DFactura_Facturas_idTipoFactura` FOREIGN KEY (`idTipoFactura`) REFERENCES `Facturas` (`idTipoFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DFactura_Productos_idProducto` FOREIGN KEY (`idProducto`) REFERENCES `Productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DFactura_Promociones_idPromocion` FOREIGN KEY (`idPromocion`) REFERENCES `Promociones` (`idPromocion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetallesFactura`
--

LOCK TABLES `DetallesFactura` WRITE;
/*!40000 ALTER TABLE `DetallesFactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetallesFactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetallesMovimientosStock`
--

DROP TABLE IF EXISTS `DetallesMovimientosStock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DetallesMovimientosStock` (
  `idDetalleMovimientoStock` bigint(20) unsigned NOT NULL,
  `idMovimiento` bigint(20) unsigned NOT NULL,
  `idInsumo` bigint(20) unsigned NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idMovimiento`,`idDetalleMovimientoStock`),
  KEY `idInsumo_idx` (`idInsumo`),
  CONSTRAINT `DMS_Insumos_idInsumo` FOREIGN KEY (`idInsumo`) REFERENCES `Insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DMS_MovimientosStock_idMovimientoStock` FOREIGN KEY (`idMovimiento`) REFERENCES `MovimientosStock` (`idMovimientoStock`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetallesMovimientosStock`
--

LOCK TABLES `DetallesMovimientosStock` WRITE;
/*!40000 ALTER TABLE `DetallesMovimientosStock` DISABLE KEYS */;
INSERT INTO `DetallesMovimientosStock` VALUES (0,1001,1001,30),(1,1001,1002,5000),(0,1002,1001,30),(1,1002,1002,5000);
/*!40000 ALTER TABLE `DetallesMovimientosStock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetallesVenta`
--

DROP TABLE IF EXISTS `DetallesVenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DetallesVenta` (
  `idDetalle` bigint(20) unsigned NOT NULL,
  `idVenta` bigint(20) unsigned NOT NULL,
  `cantidad` int(11) unsigned NOT NULL,
  `subtotal` decimal(2,0) NOT NULL,
  `idProducto` bigint(20) unsigned DEFAULT NULL,
  `idTamanio` bigint(20) unsigned DEFAULT NULL,
  `idSabor` bigint(20) unsigned DEFAULT NULL,
  `idPromocion` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`idDetalle`,`idVenta`),
  KEY `idVenta_idx` (`idVenta`),
  KEY `idSabor_idx` (`idSabor`),
  KEY `idTamanio_idx` (`idTamanio`),
  KEY `idProducto_idx` (`idProducto`),
  KEY `idPromocion_idx` (`idPromocion`),
  CONSTRAINT `DVentas_Ventas_idVenta` FOREIGN KEY (`idVenta`) REFERENCES `Ventas` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DVentas__Productos_idProducto` FOREIGN KEY (`idProducto`) REFERENCES `Productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DVentas__Promociones_idPromocion` FOREIGN KEY (`idPromocion`) REFERENCES `Promociones` (`idPromocion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DVentas__Sabores_idSabor` FOREIGN KEY (`idSabor`) REFERENCES `Sabores` (`idSabor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DVentas__Tamanios_idTamanio` FOREIGN KEY (`idTamanio`) REFERENCES `Tamanios` (`idTam`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetallesVenta`
--

LOCK TABLES `DetallesVenta` WRITE;
/*!40000 ALTER TABLE `DetallesVenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetallesVenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleados`
--

DROP TABLE IF EXISTS `Empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Empleados` (
  `idEmpleado` bigint(20) unsigned NOT NULL,
  `idFranquicia` bigint(20) unsigned NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `eMail` varchar(100) DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefonoContacto` varchar(45) NOT NULL,
  `alta` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idEmpleado`,`idFranquicia`),
  KEY `idFranquicia_idx` (`idFranquicia`),
  CONSTRAINT `Empleados_Franquicias_idFranquicia` FOREIGN KEY (`idFranquicia`) REFERENCES `Franquicias` (`idFranquicia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleados`
--

LOCK TABLES `Empleados` WRITE;
/*!40000 ALTER TABLE `Empleados` DISABLE KEYS */;
INSERT INTO `Empleados` VALUES (1001,1,'Abanto',19053216,'Diego@abanto.com','1996-11-27 00:00:00','Diego','3515466380',1),(1002,1,'Crespo',93720820,'mickaelacrespo@gmail.com','1997-03-11 00:00:00','Mickaela','3515466380',1),(1003,1,'Senn',19053216,'juanpsenn@gmail.com','1996-11-27 00:00:00','Juan Pablo','3515466380',1);
/*!40000 ALTER TABLE `Empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Facturas`
--

DROP TABLE IF EXISTS `Facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Facturas` (
  `idTipoFactura` bigint(20) unsigned NOT NULL,
  `idNumericoSucursal` bigint(20) unsigned NOT NULL,
  `idNumericoFactura` bigint(20) unsigned NOT NULL,
  `fechaHora` datetime NOT NULL,
  `montoTotal` decimal(2,0) NOT NULL,
  `eMailCliente` varchar(100) DEFAULT NULL,
  `razonSocialCliente` varchar(100) DEFAULT NULL,
  `idVenta` bigint(20) unsigned NOT NULL,
  `fechaAnulacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idTipoFactura`,`idNumericoSucursal`,`idNumericoFactura`),
  KEY `idVenta_idx` (`idVenta`),
  KEY `idFranquicia_idx` (`idNumericoSucursal`),
  CONSTRAINT `Facturas_TipoFactura_idTipo` FOREIGN KEY (`idTipoFactura`) REFERENCES `TipoFactura` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Facturas_Ventas_idFranquicia` FOREIGN KEY (`idNumericoSucursal`) REFERENCES `Ventas` (`idFranquicia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Facturas_Ventas_idVenta` FOREIGN KEY (`idVenta`) REFERENCES `Ventas` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Facturas`
--

LOCK TABLES `Facturas` WRITE;
/*!40000 ALTER TABLE `Facturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Franquicias`
--

DROP TABLE IF EXISTS `Franquicias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Franquicias` (
  `idFranquicia` bigint(20) unsigned NOT NULL,
  `CUIT` varchar(45) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `nombreDueno` varchar(45) NOT NULL,
  `eMailDueno` varchar(100) DEFAULT NULL,
  `apellidoDueno` varchar(45) NOT NULL,
  `alta` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idFranquicia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Franquicias`
--

LOCK TABLES `Franquicias` WRITE;
/*!40000 ALTER TABLE `Franquicias` DISABLE KEYS */;
INSERT INTO `Franquicias` VALUES (1,'27-93720820-6','Juan Nepper 5520','Maria Mickaela','mickaelacrespo@gmail.com','Crespo',1);
/*!40000 ALTER TABLE `Franquicias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Insumos`
--

DROP TABLE IF EXISTS `Insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Insumos` (
  `idInsumo` bigint(20) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `cantidadStock` int(11) DEFAULT NULL,
  `idUnidadMedida` bigint(20) unsigned NOT NULL,
  `stockMinimo` int(11) DEFAULT NULL,
  `alta` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idInsumo`),
  KEY `idUnidadMedida_idx` (`idUnidadMedida`),
  CONSTRAINT `Insumos_UnidadesMedida_idUnidadMedida` FOREIGN KEY (`idUnidadMedida`) REFERENCES `UnidadesMedida` (`idUnidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Insumos`
--

LOCK TABLES `Insumos` WRITE;
/*!40000 ALTER TABLE `Insumos` DISABLE KEYS */;
INSERT INTO `Insumos` VALUES (1001,'Oreo',60,1001,20,1),(1002,'Cereal',10000,1002,3000,1),(1003,'Cereales',0,1002,8000,1);
/*!40000 ALTER TABLE `Insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InsumosXProveedor`
--

DROP TABLE IF EXISTS `InsumosXProveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `InsumosXProveedor` (
  `idProveedor` bigint(20) unsigned NOT NULL,
  `idInsumo` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idProveedor`,`idInsumo`),
  KEY `idInsumo_idx` (`idInsumo`),
  CONSTRAINT `IxP_Insumos_idInsumo` FOREIGN KEY (`idInsumo`) REFERENCES `Insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IxP_Proveedores_idProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `Proveedores` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InsumosXProveedor`
--

LOCK TABLES `InsumosXProveedor` WRITE;
/*!40000 ALTER TABLE `InsumosXProveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `InsumosXProveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MovimientosStock`
--

DROP TABLE IF EXISTS `MovimientosStock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MovimientosStock` (
  `idMovimientoStock` bigint(20) unsigned NOT NULL,
  `idTurno` bigint(20) unsigned DEFAULT NULL,
  `idVenta` bigint(20) unsigned DEFAULT NULL,
  `fechaHora` datetime NOT NULL,
  `fechaHoraAnulacion` datetime DEFAULT NULL,
  `entrada` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoStock`),
  KEY `idTurno_idx` (`idTurno`),
  CONSTRAINT `MovimientosStock_Turnos_idTurno` FOREIGN KEY (`idTurno`) REFERENCES `Turnos` (`idTurno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MovimientosStock`
--

LOCK TABLES `MovimientosStock` WRITE;
/*!40000 ALTER TABLE `MovimientosStock` DISABLE KEYS */;
INSERT INTO `MovimientosStock` VALUES (1001,NULL,NULL,'2018-07-19 16:12:43',NULL,1),(1002,NULL,NULL,'2018-07-19 16:39:17',NULL,1),(1003,NULL,NULL,'2018-07-24 21:38:47',NULL,1),(1004,NULL,NULL,'2018-07-24 21:39:32',NULL,1);
/*!40000 ALTER TABLE `MovimientosStock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MovmientosCaja`
--

DROP TABLE IF EXISTS `MovmientosCaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MovmientosCaja` (
  `idMovmientoCaja` bigint(20) unsigned NOT NULL,
  `idTipoMovimiento` bigint(20) unsigned NOT NULL,
  `idTurno` bigint(20) unsigned NOT NULL,
  `fechaHora` datetime NOT NULL,
  `montoReal` decimal(2,0) NOT NULL,
  `montoSupesto` decimal(2,0) DEFAULT NULL,
  `fechaAnulacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idMovmientoCaja`),
  KEY `idTipoMov_idx` (`idTipoMovimiento`),
  KEY `idTurno_idx` (`idTurno`),
  CONSTRAINT `MovimientosCaja_TiposMovimiento_dTipoMov` FOREIGN KEY (`idTipoMovimiento`) REFERENCES `TiposMovmientos` (`idTipoMovmiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MovimientosCaja_Turnos_idTurno` FOREIGN KEY (`idTurno`) REFERENCES `Turnos` (`idTurno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MovmientosCaja`
--

LOCK TABLES `MovmientosCaja` WRITE;
/*!40000 ALTER TABLE `MovmientosCaja` DISABLE KEYS */;
/*!40000 ALTER TABLE `MovmientosCaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Perfiles`
--

DROP TABLE IF EXISTS `Perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perfiles` (
  `idPerfil` bigint(20) unsigned NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Perfiles`
--

LOCK TABLES `Perfiles` WRITE;
/*!40000 ALTER TABLE `Perfiles` DISABLE KEYS */;
INSERT INTO `Perfiles` VALUES (1001,'admin'),(1002,'owner'),(1003,'employee');
/*!40000 ALTER TABLE `Perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PerfilesXUsuarios`
--

DROP TABLE IF EXISTS `PerfilesXUsuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PerfilesXUsuarios` (
  `idUsuario` bigint(20) unsigned NOT NULL,
  `idPerfil` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idUsuario`,`idPerfil`),
  KEY `idPerfil_idx` (`idPerfil`),
  CONSTRAINT `idPerfil` FOREIGN KEY (`idPerfil`) REFERENCES `Perfiles` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idUsuarios` FOREIGN KEY (`idUsuario`) REFERENCES `Usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PerfilesXUsuarios`
--

LOCK TABLES `PerfilesXUsuarios` WRITE;
/*!40000 ALTER TABLE `PerfilesXUsuarios` DISABLE KEYS */;
INSERT INTO `PerfilesXUsuarios` VALUES (1002,1001),(1003,1002),(1001,1003);
/*!40000 ALTER TABLE `PerfilesXUsuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Permisos`
--

DROP TABLE IF EXISTS `Permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Permisos` (
  `idPermiso` bigint(20) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Permisos`
--

LOCK TABLES `Permisos` WRITE;
/*!40000 ALTER TABLE `Permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PermisosXPerfil`
--

DROP TABLE IF EXISTS `PermisosXPerfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PermisosXPerfil` (
  `idPerfil` bigint(20) unsigned NOT NULL,
  `idPermiso` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idPerfil`,`idPermiso`),
  KEY `idPermiso_idx` (`idPermiso`),
  CONSTRAINT `PxP_Perfiles_idPerfil` FOREIGN KEY (`idPerfil`) REFERENCES `Perfiles` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PxP_Permisos_idPermiso` FOREIGN KEY (`idPermiso`) REFERENCES `Permisos` (`idPermiso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PermisosXPerfil`
--

LOCK TABLES `PermisosXPerfil` WRITE;
/*!40000 ALTER TABLE `PermisosXPerfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `PermisosXPerfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Productos`
--

DROP TABLE IF EXISTS `Productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Productos` (
  `idProducto` bigint(20) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `alta` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Productos`
--

LOCK TABLES `Productos` WRITE;
/*!40000 ALTER TABLE `Productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Promociones`
--

DROP TABLE IF EXISTS `Promociones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Promociones` (
  `idPromocion` bigint(20) unsigned NOT NULL,
  `activo` bigint(20) unsigned NOT NULL,
  `fechaVigencia` datetime NOT NULL,
  `porcentajeDescuento` decimal(2,0) NOT NULL,
  `requisito` varchar(300) DEFAULT NULL,
  `alta` tinyint(1) DEFAULT '1',
  `Promociones_idPromocion` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idPromocion`,`Promociones_idPromocion`),
  KEY `fk_Promociones_Promociones1_idx` (`Promociones_idPromocion`),
  CONSTRAINT `fk_Promociones_Promociones1` FOREIGN KEY (`Promociones_idPromocion`) REFERENCES `Promociones` (`idPromocion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Promociones`
--

LOCK TABLES `Promociones` WRITE;
/*!40000 ALTER TABLE `Promociones` DISABLE KEYS */;
/*!40000 ALTER TABLE `Promociones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedores`
--

DROP TABLE IF EXISTS `Proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Proveedores` (
  `idProveedor` bigint(20) unsigned NOT NULL,
  `CUIT` varchar(45) NOT NULL,
  `razonSocial` varchar(100) NOT NULL,
  `eMail` varchar(100) DEFAULT NULL,
  `telefonoContacto` varchar(45) DEFAULT NULL,
  `alta` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedores`
--

LOCK TABLES `Proveedores` WRITE;
/*!40000 ALTER TABLE `Proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `Proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProveedoresXFranquica`
--

DROP TABLE IF EXISTS `ProveedoresXFranquica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProveedoresXFranquica` (
  `idProveedor` bigint(20) unsigned NOT NULL,
  `idFranquicia` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idProveedor`,`idFranquicia`),
  KEY `idFranquicia_idx` (`idFranquicia`),
  CONSTRAINT `PxF_Franquicias_idFranquicia` FOREIGN KEY (`idFranquicia`) REFERENCES `Franquicias` (`idFranquicia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PxF_Proveedores_idProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `Proveedores` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProveedoresXFranquica`
--

LOCK TABLES `ProveedoresXFranquica` WRITE;
/*!40000 ALTER TABLE `ProveedoresXFranquica` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProveedoresXFranquica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sabores`
--

DROP TABLE IF EXISTS `Sabores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sabores` (
  `idSabor` bigint(20) unsigned NOT NULL,
  `nombe` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSabor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sabores`
--

LOCK TABLES `Sabores` WRITE;
/*!40000 ALTER TABLE `Sabores` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sabores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SaboresXProducto`
--

DROP TABLE IF EXISTS `SaboresXProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SaboresXProducto` (
  `idProducto` bigint(20) unsigned NOT NULL,
  `idSabor` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idProducto`,`idSabor`),
  KEY `idSabor_idx` (`idSabor`),
  CONSTRAINT `SxP_Productos_idProducto` FOREIGN KEY (`idProducto`) REFERENCES `Productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SxP_Sabores_idSabor` FOREIGN KEY (`idSabor`) REFERENCES `Sabores` (`idSabor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SaboresXProducto`
--

LOCK TABLES `SaboresXProducto` WRITE;
/*!40000 ALTER TABLE `SaboresXProducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `SaboresXProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sesiones`
--

DROP TABLE IF EXISTS `Sesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sesiones` (
  `idSesion` bigint(20) unsigned NOT NULL,
  `idUsuario` bigint(20) unsigned NOT NULL,
  `fechaHoraInicio` datetime NOT NULL,
  `fechaHoraFin` datetime DEFAULT NULL,
  PRIMARY KEY (`idSesion`),
  KEY `idUsuario_idx` (`idUsuario`),
  CONSTRAINT `Sesiones_Usuarios_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `Usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sesiones`
--

LOCK TABLES `Sesiones` WRITE;
/*!40000 ALTER TABLE `Sesiones` DISABLE KEYS */;
INSERT INTO `Sesiones` VALUES (1001,1001,'2018-07-27 13:53:41','2018-07-27 14:46:51');
/*!40000 ALTER TABLE `Sesiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tamanios`
--

DROP TABLE IF EXISTS `Tamanios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tamanios` (
  `idTam` bigint(20) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(2,0) NOT NULL,
  PRIMARY KEY (`idTam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tamanios`
--

LOCK TABLES `Tamanios` WRITE;
/*!40000 ALTER TABLE `Tamanios` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tamanios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TamaniosXProductos`
--

DROP TABLE IF EXISTS `TamaniosXProductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TamaniosXProductos` (
  `idTamanio` bigint(20) unsigned NOT NULL,
  `idProducto` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idTamanio`,`idProducto`),
  KEY `idProducto_idx` (`idProducto`),
  CONSTRAINT `TxP_Tamanios_idTamanio` FOREIGN KEY (`idTamanio`) REFERENCES `Tamanios` (`idTam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TxP__Productos_idProducto` FOREIGN KEY (`idProducto`) REFERENCES `Productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TamaniosXProductos`
--

LOCK TABLES `TamaniosXProductos` WRITE;
/*!40000 ALTER TABLE `TamaniosXProductos` DISABLE KEYS */;
/*!40000 ALTER TABLE `TamaniosXProductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoFactura`
--

DROP TABLE IF EXISTS `TipoFactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoFactura` (
  `idTipo` bigint(20) unsigned NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `letra` varchar(5) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoFactura`
--

LOCK TABLES `TipoFactura` WRITE;
/*!40000 ALTER TABLE `TipoFactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoFactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TiposMovmientos`
--

DROP TABLE IF EXISTS `TiposMovmientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TiposMovmientos` (
  `idTipoMovmiento` bigint(20) unsigned NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipoMovmiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TiposMovmientos`
--

LOCK TABLES `TiposMovmientos` WRITE;
/*!40000 ALTER TABLE `TiposMovmientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `TiposMovmientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Turnos`
--

DROP TABLE IF EXISTS `Turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Turnos` (
  `idTurno` bigint(20) unsigned NOT NULL,
  `idSesion` bigint(20) unsigned NOT NULL,
  `fechaHoraInicio` datetime NOT NULL,
  `fechaHoraFin` datetime DEFAULT NULL,
  PRIMARY KEY (`idTurno`),
  KEY `idSesion_idx` (`idSesion`),
  CONSTRAINT `Turnos_Sesiones_idSesion` FOREIGN KEY (`idSesion`) REFERENCES `Sesiones` (`idSesion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Turnos`
--

LOCK TABLES `Turnos` WRITE;
/*!40000 ALTER TABLE `Turnos` DISABLE KEYS */;
INSERT INTO `Turnos` VALUES (1001,1001,'2018-07-27 14:44:54','2018-07-27 14:46:37');
/*!40000 ALTER TABLE `Turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UnidadesMedida`
--

DROP TABLE IF EXISTS `UnidadesMedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UnidadesMedida` (
  `idUnidad` bigint(20) unsigned NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UnidadesMedida`
--

LOCK TABLES `UnidadesMedida` WRITE;
/*!40000 ALTER TABLE `UnidadesMedida` DISABLE KEYS */;
INSERT INTO `UnidadesMedida` VALUES (1001,'Paquetes'),(1002,'Gramos'),(1003,'Litros'),(1004,'Cajas'),(1005,'Unidad'),(1006,'Cajitas de carton'),(1007,'Cajitas de lata'),(1008,'lalala');
/*!40000 ALTER TABLE `UnidadesMedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `idUsuario` bigint(20) unsigned NOT NULL,
  `idEmpleado` bigint(20) unsigned NOT NULL,
  `idFranquicia` bigint(20) unsigned NOT NULL,
  `password` varchar(250) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idEmpleado_idx` (`idEmpleado`),
  KEY `idFranquicia_idx` (`idFranquicia`),
  CONSTRAINT `Usuarios_Empleados_idEmpleado` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleados` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idFranquicia` FOREIGN KEY (`idFranquicia`) REFERENCES `Empleados` (`idFranquicia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (1001,1001,1,'$2a$12$1qCslUPZpsCeKXadFN0pv.aUhiXhCQ.q0NqVpKdXDaHF/i9l63Tva','diego'),(1002,1002,1,'$2a$12$qNUQPiimM9tMLSX37aqj4esn//2mcJz6psGdzUIpGD0s9X1W9WbJW','micka'),(1003,1003,1,'$2a$12$4YVfXpa7lLW8OofHinGrkOKKhIW4Ua5IoU3MkEg5mNCaHud2VOfV2','juan');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ventas`
--

DROP TABLE IF EXISTS `Ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ventas` (
  `idVenta` bigint(20) unsigned NOT NULL,
  `montoTotal` decimal(2,0) DEFAULT NULL,
  `fechaHoraVenta` datetime NOT NULL,
  `idFranquicia` bigint(20) unsigned NOT NULL,
  `fechaAnulacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idVenta`,`idFranquicia`),
  KEY `idFranquicia_idx` (`idFranquicia`),
  CONSTRAINT `Ventas_Franquicias_idFranquicia` FOREIGN KEY (`idFranquicia`) REFERENCES `Franquicias` (`idFranquicia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ventas`
--

LOCK TABLES `Ventas` WRITE;
/*!40000 ALTER TABLE `Ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-27 14:51:16
