-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-12-2024 a las 22:44:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `addamagil0`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(30) NOT NULL,
  `capellidos` varchar(30) NOT NULL,
  `nedad` int(11) NOT NULL,
  PRIMARY KEY (`ncodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ncodigo`, `cnombre`, `capellidos`, `nedad`) VALUES
(1, 'Pepe', 'Gonzalez Bueno', 45),
(2, 'Jose Vte.', 'Navarro Gomez', 23),
(3, 'Luis', 'Tena Rodrigez', 56),
(4, 'Santiago', 'Piquer Alamilla', 78),
(5, 'Rebeca', 'Sorribes Garcia', 12),
(6, 'Eva', 'Rosell Ventura', 45),
(7, 'Jorge', 'Ribes Garcia', 55),
(8, 'David', 'Robles Nieto', 88),
(9, 'Joan', 'Moliner Llido', 23),
(10, 'Pablo', 'Guerola Burdeus', 65),
(11, 'Alberto', 'Fuentes Morales', 33),
(12, 'Roger', 'Motos Ruiz', 21),
(13, 'Rafa', 'Marti Ventura', 22),
(14, 'Hernesto', 'Moliner Gonzalez', 5),
(15, 'Lucas', 'Tormos Meseger', 6);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
