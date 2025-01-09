-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-01-2025 a las 09:04:34
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `centro`
--
CREATE DATABASE IF NOT EXISTS `centro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `centro`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administracion`
--

DROP TABLE IF EXISTS `administracion`;
CREATE TABLE IF NOT EXISTS `administracion` (
  `codigo` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `anyos_trabajados` int(11) NOT NULL,
  `departamento` varchar(30) NOT NULL,
  `horario` varchar(1) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `id_persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administracion`
--

INSERT INTO `administracion` (`codigo`, `id_persona`, `anyos_trabajados`, `departamento`, `horario`) VALUES
(4, 31, 15, 'rrhh', 'M'),
(5, 33, 15, 'l', 'T');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE IF NOT EXISTS `alumnos` (
  `codigo` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `curso` int(11) NOT NULL,
  `carrera` varchar(50) NOT NULL,
  `nota_media` decimal(10,0) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `id_persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`codigo`, `id_persona`, `curso`, `carrera`, `nota_media`) VALUES
(1, 28, 7, 'periodismo', '7'),
(2, 29, 4, 'magisterio', '8'),
(3, 30, 6, 'magisteria', '8'),
(4, 32, 5, 'ccaa', '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_fiscales`
--

DROP TABLE IF EXISTS `datos_fiscales`;
CREATE TABLE IF NOT EXISTS `datos_fiscales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `nif` varchar(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `poblacion` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `poblacion` (`poblacion`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `datos_fiscales`
--

INSERT INTO `datos_fiscales` (`id`, `nombre`, `apellidos`, `nif`, `edad`, `poblacion`) VALUES
(28, 'pep', 'luiozao', '24157896J', 11, 1),
(29, 'josep', 'lsdl', '4444444F', 77, 1),
(30, 'joaa', 'moliner', '77777777k', 66, 1),
(31, 'pepe', 'ruiz', '2541541L', 19, 1),
(32, 'yoel', 'lls', '33333333L', 44, 2),
(33, 'luis', 'molina', '555555555O', 19, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblaciones`
--

DROP TABLE IF EXISTS `poblaciones`;
CREATE TABLE IF NOT EXISTS `poblaciones` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `cod_postal` varchar(12) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `poblaciones`
--

INSERT INTO `poblaciones` (`codigo`, `nombre`, `cod_postal`) VALUES
(1, 'Burriana', '12530'),
(2, 'Oropesa', '11111111'),
(3, 'Castellon', '11177445');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administracion`
--
ALTER TABLE `administracion`
  ADD CONSTRAINT `administracion_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `datos_fiscales` (`id`);

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `datos_fiscales` (`id`);

--
-- Filtros para la tabla `datos_fiscales`
--
ALTER TABLE `datos_fiscales`
  ADD CONSTRAINT `datos_fiscales_ibfk_1` FOREIGN KEY (`poblacion`) REFERENCES `poblaciones` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
