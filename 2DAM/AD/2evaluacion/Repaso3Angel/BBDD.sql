-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-01-2020 a las 13:22:11
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `agilges`
--
CREATE DATABASE IF NOT EXISTS `agilges` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `agilges`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--
DROP TABLE IF EXISTS `documentos`;
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(50) NOT NULL,
  `capellidos` varchar(50) NOT NULL,
  `cnif` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documentos`
--


CREATE TABLE `documentos` (
  `ncodigo` int(11) NOT NULL,
  `ncliente` int(11) NOT NULL,
  `ctipo` varchar(20) NOT NULL,
  `bdoc` longblob NOT NULL,
  `bmeta` blob NOT NULL,
  `cfichero` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ncodigo`);

--
-- Indices de la tabla `documentos`
--
ALTER TABLE `documentos`
  ADD PRIMARY KEY (`ncodigo`),
  ADD KEY `ncliente` (`ncliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `documentos`
--
ALTER TABLE `documentos`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `documentos`
--
ALTER TABLE `documentos`
  ADD CONSTRAINT `documentos_ibfk_1` FOREIGN KEY (`ncliente`) REFERENCES `clientes` (`ncodigo`);
COMMIT;
