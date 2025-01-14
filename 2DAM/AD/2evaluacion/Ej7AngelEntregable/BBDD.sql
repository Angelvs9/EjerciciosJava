-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-01-2024 a las 10:04:56
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `minferreteria`
--
CREATE DATABASE IF NOT EXISTS `minferreteria` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `minferreteria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `ncodigo` int(11) NOT NULL,
  `ccif` varchar(10) DEFAULT NULL,
  `cnombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `capellidos` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `ctelefono` varchar(12) DEFAULT NULL,
  `cfax` varchar(12) DEFAULT NULL,
  `cdireccion` varchar(50) DEFAULT NULL,
  `bfoto` longblob DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ncodigo`, `ccif`, `cnombre`, `capellidos`, `ctelefono`, `cfax`, `cdireccion`, `bfoto`) VALUES
(1, 'A12345673', 'Pepe', 'Gonzalez Bueno', '964556645', '964678764', 'C/Pintor Sorolla,8', NULL),
(3, 'A12345675', 'Luis', 'Tena Rodrigez', '964556647', '964678764', 'C/El Raval,98', NULL),
(4, 'A12345676', 'Santiago', 'Piquer Alamilla', '964556648', '964678764', 'C/Martinez Gavara,78', NULL),
(5, 'A64345678', 'Rebeca', 'Sorribes Garcia', '964556649', '964678764', 'C/Alberto Figueroa,23', NULL),
(6, 'G64345679', 'Eva', 'Rosell Ventura', '964556650', '964678764', 'C/Buen Suceso,23', NULL),
(7, 'A64345680', 'Jorge', 'Ribes Garcia', '964556651', '964678764', 'Avda. Mediterraneo s/n', NULL),
(8, 'A64345681', 'David', 'Robles Nieto', '964556652', '964678764', 'Pol. Carabona s/n', NULL),
(9, 'J64345682', 'Joan', 'Moliner Llido', '964556653', '964678764', 'C/Escorredor,23', NULL),
(10, 'A64345683', 'Pablo', 'Guerola Burdeus', '964556654', '964678764', 'C/Finello,67', NULL),
(11, 'M54345684', 'Alberto', 'Fuentes Morales', '964556655', '964678764', 'C/Europa,23', NULL),
(12, 'O54345685', 'Roger', 'Motos Ruiz', '964556656', '964678764', 'C/Lluis Vives,23', NULL),
(13, 'A54345686', 'Rafa', 'Marti Ventura', '964556657', '964678764', 'C/Joan Martorell,7', NULL),
(14, 'P54345687', 'Hernesto', 'Moliner Gonzalez', '964556658', '964678764', 'Avd. Chicharro s/n', NULL),
(15, 'A54345688', 'Lucas', 'Tormos Meseger', '964556659', '964678764', 'C/Cinco de julio', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ncodigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;
