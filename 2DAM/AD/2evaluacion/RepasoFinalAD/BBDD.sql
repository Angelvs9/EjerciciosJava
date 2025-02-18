-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-03-2019 a las 19:02:19
-- Versión del servidor: 10.1.33-MariaDB
-- Versión de PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `juntisima`
--
CREATE DATABASE IF NOT EXISTS `juntisima` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `juntisima`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cofrades`
--

DROP TABLE IF EXISTS `cofrades`;
CREATE TABLE `cofrades` (
  `ncodigo` int(11) NOT NULL,
  `ncofradia` int(11) NOT NULL,
  `cnombre` varchar(20) NOT NULL,
  `capellidos` varchar(40) NOT NULL,
  `ctelefono` varchar(15) NOT NULL,
  `nedad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cofradias`
--

DROP TABLE IF EXISTS `cofradias`;
CREATE TABLE `cofradias` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(40) NOT NULL,
  `cdireccion` varchar(40) NOT NULL,
  `bfoto` longblob NOT NULL,
  `cfichero` varchar(40) NOT NULL,
  `nparroquia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parroquias`
--

DROP TABLE IF EXISTS `parroquias`;
CREATE TABLE `parroquias` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(40) NOT NULL,
  `cdireccion` varchar(40) NOT NULL,
  `csacerdote` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cofrades`
--
ALTER TABLE `cofrades`
  ADD PRIMARY KEY (`ncodigo`),
  ADD KEY `ncofradia` (`ncofradia`);

--
-- Indices de la tabla `cofradias`
--
ALTER TABLE `cofradias`
  ADD PRIMARY KEY (`ncodigo`),
  ADD KEY `nparroquia` (`nparroquia`);

--
-- Indices de la tabla `parroquias`
--
ALTER TABLE `parroquias`
  ADD PRIMARY KEY (`ncodigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cofrades`
--
ALTER TABLE `cofrades`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cofradias`
--
ALTER TABLE `cofradias`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cofrades`
--
ALTER TABLE `cofrades`
  ADD CONSTRAINT `cofrades_ibfk_1` FOREIGN KEY (`ncofradia`) REFERENCES `cofradias` (`ncodigo`);

--
-- Filtros para la tabla `cofradias`
--
ALTER TABLE `cofradias`
  ADD CONSTRAINT `cofradias_ibfk_1` FOREIGN KEY (`nparroquia`) REFERENCES `parroquias` (`ncodigo`);
COMMIT;
