-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2024 a las 12:27:22
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
-- Base de datos: `notasevaluaciones`
--
CREATE DATABASE IF NOT EXISTS `notasevaluaciones` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `notasevaluaciones`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE IF NOT EXISTS `alumnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'entero auto',
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(25) NOT NULL,
  `edad` int(11) NOT NULL,
  `curso` int(11) NOT NULL,
  `NIF` char(9) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NIF` (`NIF`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombre`, `apellidos`, `edad`, `curso`, `NIF`) VALUES
(1, 'pepe', 'fonsi', 19, 4, '26984157H'),
(2, 'carlos', 'garcia', 10, 2, '64578951E'),
(7, 'josefa', 'ruiz', 11, 4, '64512378K'),
(8, 'carla', 'sanchez', 15, 6, '71717152J');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion`
--

DROP TABLE IF EXISTS `evaluacion`;
CREATE TABLE IF NOT EXISTS `evaluacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `evaluacion` varchar(5) NOT NULL COMMENT 'puede ser 1 2 3 rec o final por eso es de 5 de longitud',
  `nota` double NOT NULL,
  `alumnoNif` char(9) NOT NULL COMMENT 'relación de tabla',
  PRIMARY KEY (`id`),
  KEY `relacion` (`alumnoNif`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `evaluacion`
--

INSERT INTO `evaluacion` (`id`, `evaluacion`, `nota`, `alumnoNif`) VALUES
(1, '1', 5.55, '71717152J'),
(2, '2', 4.99, '64512378K'),
(3, 'final', 9, '26984157H'),
(4, 'rec', 7, '64578951E');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `evaluacion`
--
ALTER TABLE `evaluacion`
  ADD CONSTRAINT `relacion` FOREIGN KEY (`alumnoNif`) REFERENCES `alumnos` (`NIF`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
