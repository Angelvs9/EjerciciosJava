-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-01-2024 a las 07:55:41
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `audiogil`
--
CREATE DATABASE IF NOT EXISTS `audiogil` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `audiogil`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anotaciones`
--

DROP TABLE IF EXISTS `anotaciones`;
CREATE TABLE `anotaciones` (
  `codigo` bigint(20) UNSIGNED NOT NULL,
  `cc` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `debe` decimal(10,0) NOT NULL,
  `haber` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `codigo` bigint(20) UNSIGNED NOT NULL,
  `dato_fiscal` bigint(20) UNSIGNED NOT NULL,
  `telf_contacto` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_cliente`
--

DROP TABLE IF EXISTS `cuenta_cliente`;
CREATE TABLE `cuenta_cliente` (
  `codigo` varchar(50) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `saldo` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_fiscales`
--

DROP TABLE IF EXISTS `datos_fiscales`;
CREATE TABLE `datos_fiscales` (
  `codigo` bigint(20) UNSIGNED NOT NULL,
  `nif` varchar(15) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `cc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblaciones`
--

DROP TABLE IF EXISTS `poblaciones`;
CREATE TABLE `poblaciones` (
  `codigo` varchar(5) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anotaciones`
--
ALTER TABLE `anotaciones`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `fk_cuenta` (`cc`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `fk_datosfiscales` (`dato_fiscal`);

--
-- Indices de la tabla `cuenta_cliente`
--
ALTER TABLE `cuenta_cliente`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `datos_fiscales`
--
ALTER TABLE `datos_fiscales`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `fk_poblaciones` (`cp`),
  ADD KEY `fk_cc` (`cc`);

--
-- Indices de la tabla `poblaciones`
--
ALTER TABLE `poblaciones`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anotaciones`
--
ALTER TABLE `anotaciones`
  MODIFY `codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `datos_fiscales`
--
ALTER TABLE `datos_fiscales`
  MODIFY `codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `anotaciones`
--
ALTER TABLE `anotaciones`
  ADD CONSTRAINT `fk_cuenta` FOREIGN KEY (`cc`) REFERENCES `cuenta_cliente` (`codigo`);

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `fk_datosfiscales` FOREIGN KEY (`dato_fiscal`) REFERENCES `datos_fiscales` (`codigo`);

--
-- Filtros para la tabla `datos_fiscales`
--
ALTER TABLE `datos_fiscales`
  ADD CONSTRAINT `fk_cc` FOREIGN KEY (`cc`) REFERENCES `cuenta_cliente` (`codigo`),
  ADD CONSTRAINT `fk_poblaciones` FOREIGN KEY (`cp`) REFERENCES `poblaciones` (`codigo`);
COMMIT;
