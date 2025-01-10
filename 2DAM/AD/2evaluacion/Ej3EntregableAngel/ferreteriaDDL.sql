CREATE DATABASE  IF NOT EXISTS `ferreteria` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `ferreteria`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: ferreteria
-- ------------------------------------------------------
-- Server version	5.1.37

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
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `ccodigo` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cfamilia` varchar(5) DEFAULT NULL,
  `cnombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `cdescripcion` varchar(50) DEFAULT NULL,
  `npeso` smallint(6) DEFAULT NULL,
  `npi_caja` smallint(6) DEFAULT NULL,
  `ncoste` double DEFAULT NULL,
  `dfecha_alta` datetime DEFAULT NULL,
  `lobsoleto` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ccodigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;




--
-- Table structure for table `cab_ped`
--

DROP TABLE IF EXISTS `cab_ped`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cab_ped` (
  `norden` int(11) NOT NULL DEFAULT '0',
  `nanyo` smallint(6) NOT NULL DEFAULT '0',
  `dfecha` datetime DEFAULT NULL,
  `ncliente` int(11) DEFAULT NULL,
  `cforma_pago` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`norden`,`nanyo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `ncodigo` int(11) NOT NULL DEFAULT '0',
  `ccif` varchar(10) DEFAULT NULL,
  `cnombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `capellidos` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `ctelefono` varchar(12) DEFAULT NULL,
  `cfax` varchar(12) DEFAULT NULL,
  `cdireccion` varchar(50) DEFAULT NULL,
  `cpoblacion` varchar(5) DEFAULT NULL,
  `cforma_pago` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ncodigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `familias`
--

DROP TABLE IF EXISTS `familias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familias` (
  `ccodigo` varchar(5) NOT NULL DEFAULT '',
  `cnombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `mobservaciones` mediumtext,
  PRIMARY KEY (`ccodigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `formas_pago`
--

DROP TABLE IF EXISTS `formas_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formas_pago` (
  `ccodigo` varchar(3) NOT NULL DEFAULT '',
  `cnombre` varchar(20) DEFAULT NULL,
  `nvencimiento` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ccodigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `lin_ped`
--

DROP TABLE IF EXISTS `lin_ped`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lin_ped` (
  `norden` int(11) NOT NULL DEFAULT '0',
  `nanyo` smallint(6) NOT NULL DEFAULT '0',
  `carticulo` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `niva` smallint(6) DEFAULT NULL,
  `nprecio` double DEFAULT NULL,
  `nunidades` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`norden`,`nanyo`,`carticulo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `ccodigo` varchar(3) NOT NULL DEFAULT '',
  `cnombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ccodigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `poblaciones`
--

DROP TABLE IF EXISTS `poblaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poblaciones` (
  `ccodigo` varchar(6) NOT NULL DEFAULT '',
  `cnombre` varchar(20) DEFAULT NULL,
  `cprovincia` varchar(3) DEFAULT NULL,
  `cpostal` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ccodigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `ccodigo` varchar(3) NOT NULL DEFAULT '',
  `cnombre` varchar(20) DEFAULT NULL,
  `cpais` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ccodigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-01  9:24:55
