-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2017 a las 13:16:16
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `examen`
--
CREATE DATABASE IF NOT EXISTS `examen` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `examen`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `ID` int(10) NOT NULL,
  `Nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono` int(9) NOT NULL,
  `NIF` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `NumeroDeCuenta` int(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID`, `Nombre`, `Direccion`, `Telefono`, `NIF`, `NumeroDeCuenta`) VALUES
(1, 'Jorge Mercado Martin', 'C/Via Tarpeya 19 Casa 21', 615588926, '03930971H', 3930971),
(2, 'Aitor Menta Fresca', 'C/Oklahoma 76', 647852172, '03930972H', 3930972),
(3, 'Lucas Trado Fuerte', 'C/Testiculos 0', 654238574, '03930973H', 3930973);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentabancaria`
--

DROP TABLE IF EXISTS `cuentabancaria`;
CREATE TABLE `cuentabancaria` (
  `Banco` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Sucursal` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `DigitoDeControl` int(4) NOT NULL,
  `NumeroDeCuenta` int(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cuentabancaria`
--

INSERT INTO `cuentabancaria` (`Banco`, `Sucursal`, `DigitoDeControl`, `NumeroDeCuenta`) VALUES
('Bankia', 'Toledo', 1111, 3930971),
('Santander', 'Toledo', 2222, 3930972),
('Bankia', 'Toledo', 111, 3930973);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `ID` int(10) NOT NULL,
  `Codigo` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `FechaCreacion` date NOT NULL,
  `FechaAceptacion` date NOT NULL,
  `Comentarios` varchar(5000) COLLATE utf8_spanish_ci NOT NULL,
  `IdCliente` int(24) NOT NULL,
  `ImporteTotal` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`ID`, `Codigo`, `FechaCreacion`, `FechaAceptacion`, `Comentarios`, `IdCliente`, `ImporteTotal`) VALUES
(1, '2561', '2017-03-01', '2017-03-01', 'Primer Pedido', 1, 20),
(2, '211', '2017-03-02', '2017-03-02', 'Segundo pedido', 1, 50),
(3, '48', '2017-03-03', '2017-03-03', 'tercer pedido', 2, 30),
(4, '4189', '2017-03-02', '2017-03-02', 'cuarto pedido', 1, 40),
(5, '18', '2017-03-09', '2017-03-09', 'quinto pedido', 2, 100),
(6, '798', '2017-03-13', '2017-03-13', 'Sexto pedido', 3, 70);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `ID` int(10) NOT NULL,
  `Fabricante` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Precio` int(4) NOT NULL,
  `Descripcion` varchar(5000) COLLATE utf8_spanish_ci NOT NULL,
  `IdPedido` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `NumeroDeCuenta` (`NumeroDeCuenta`);

--
-- Indices de la tabla `cuentabancaria`
--
ALTER TABLE `cuentabancaria`
  ADD PRIMARY KEY (`NumeroDeCuenta`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IdCliente` (`IdCliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD KEY `IdPedido` (`IdPedido`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`NumeroDeCuenta`) REFERENCES `cuentabancaria` (`NumeroDeCuenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`IdPedido`) REFERENCES `pedido` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
