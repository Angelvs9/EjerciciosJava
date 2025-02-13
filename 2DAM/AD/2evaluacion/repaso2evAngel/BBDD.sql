-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-04-2019 a las 12:58:20
-- Versión del servidor: 10.1.33-MariaDB
-- Versión de PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `seriestv`
--
CREATE DATABASE IF NOT EXISTS `seriestv` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `seriestv`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canales`
--

DROP TABLE IF EXISTS `canales`;
CREATE TABLE `canales` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(30) NOT NULL,
  `nprecio` int(11) NOT NULL,
  `nseries` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `protagonistas`
--

DROP TABLE IF EXISTS `protagonistas`;
CREATE TABLE `protagonistas` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(50) NOT NULL,
  `nedad` int(11) NOT NULL,
  `bcurriculum` longblob NOT NULL,
  `nserie` int(11) NOT NULL,
  `ccurriculum` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `series`
--

DROP TABLE IF EXISTS `series`;
CREATE TABLE `series` (
  `ncodigo` int(11) NOT NULL,
  `ctitulo` varchar(40) NOT NULL,
  `cgenero` varchar(40) NOT NULL,
  `nanyo` int(11) NOT NULL,
  `bfoto` longblob NOT NULL,
  `ncanal` int(11) NOT NULL,
  `cfoto` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `canales`
--
ALTER TABLE `canales`
  ADD PRIMARY KEY (`ncodigo`);

--
-- Indices de la tabla `protagonistas`
--
ALTER TABLE `protagonistas`
  ADD PRIMARY KEY (`ncodigo`),
  ADD KEY `nserie` (`nserie`);

--
-- Indices de la tabla `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`ncodigo`),
  ADD KEY `ncanal` (`ncanal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `canales`
--
ALTER TABLE `canales`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;
