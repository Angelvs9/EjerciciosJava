-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-12-2024 a las 12:11:00
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `vending`
--
CREATE DATABASE IF NOT EXISTS `vending` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vending`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `locales`
--

DROP TABLE IF EXISTS `locales`;
CREATE TABLE `locales` (
  `ncodigo` int(11) NOT NULL,
  `cpoblacion` varchar(30) NOT NULL,
  `cdireccion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquina`
--

DROP TABLE IF EXISTS `maquina`;
CREATE TABLE `maquina` (
  `ncodigo` int(11) NOT NULL,
  `cmodelo` varchar(30) NOT NULL,
  `npeso` double NOT NULL,
  `naltura` double NOT NULL,
  `nlocal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquina_producto`
--

DROP TABLE IF EXISTS `maquina_producto`;
CREATE TABLE `maquina_producto` (
  `nmaquina` int(11) NOT NULL,
  `nproducto` int(11) NOT NULL,
  `ncantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(30) NOT NULL,
  `nprecio` double NOT NULL,
  `bfoto` longblob DEFAULT NULL,
  `bnutrientes` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `locales`
--
ALTER TABLE `locales`
  ADD PRIMARY KEY (`ncodigo`);

--
-- Indices de la tabla `maquina`
--
ALTER TABLE `maquina`
  ADD PRIMARY KEY (`ncodigo`),
  ADD KEY `nlocal` (`nlocal`);

--
-- Indices de la tabla `maquina_producto`
--
ALTER TABLE `maquina_producto`
  ADD PRIMARY KEY (`nmaquina`,`nproducto`),
  ADD KEY `nproducto` (`nproducto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ncodigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `locales`
--
ALTER TABLE `locales`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `maquina`
--
ALTER TABLE `maquina`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `maquina`
--
ALTER TABLE `maquina`
  ADD CONSTRAINT `maquina_ibfk_1` FOREIGN KEY (`nlocal`) REFERENCES `locales` (`ncodigo`);

--
-- Filtros para la tabla `maquina_producto`
--
ALTER TABLE `maquina_producto`
  ADD CONSTRAINT `maquina_producto_ibfk_1` FOREIGN KEY (`nmaquina`) REFERENCES `maquina` (`ncodigo`),
  ADD CONSTRAINT `maquina_producto_ibfk_2` FOREIGN KEY (`nproducto`) REFERENCES `productos` (`ncodigo`);
COMMIT;
