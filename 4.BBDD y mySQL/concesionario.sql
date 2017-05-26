-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-03-2017 a las 10:04:17
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `concesionario`
--
CREATE DATABASE IF NOT EXISTS `concesionario` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `concesionario`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camiones`
--

DROP TABLE IF EXISTS `camiones`;
CREATE TABLE `camiones` (
  `n_bastidor` int(155) NOT NULL,
  `color` varchar(22) COLLATE utf8_spanish_ci NOT NULL,
  `modelo` varchar(22) COLLATE utf8_spanish_ci NOT NULL,
  `marca` varchar(22) COLLATE utf8_spanish_ci NOT NULL,
  `matricula` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `motor` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `remolque` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `peso_Vacio` int(10) NOT NULL,
  `peso_con_carga` int(10) NOT NULL,
  `n_ruedas` int(11) NOT NULL,
  `precio` int(6) NOT NULL,
  `n_vendedor` varchar(22) COLLATE utf8_spanish_ci NOT NULL,
  `n_cliente` varchar(22) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `n_cliente` int(22) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `dni` int(7) NOT NULL,
  `edad` int(3) NOT NULL,
  `email` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(12) NOT NULL,
  `direccion` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `sexo` varchar(3) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_carnet` varchar(3) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
CREATE TABLE `vendedor` (
  `n_vendedor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(22) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(22) COLLATE utf8_spanish_ci NOT NULL,
  `dni` int(8) NOT NULL,
  `email` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `clientes` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `total_ventas` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
