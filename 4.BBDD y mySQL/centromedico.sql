-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2017 a las 09:25:50
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `centromedico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresos`
--

CREATE TABLE `ingresos` (
  `ID` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Procedencia` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Fecha_de_ingreso` date NOT NULL,
  `Numero_de_planta` int(3) NOT NULL,
  `Numero_de_cama` int(5) NOT NULL,
  `Observaciones` varchar(500) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ingresos`
--

INSERT INTO `ingresos` (`ID`, `Procedencia`, `Fecha_de_ingreso`, `Numero_de_planta`, `Numero_de_cama`, `Observaciones`) VALUES
('MRMR931225911016', 'Toledo', '2017-03-01', 69, 69, ''),
('MRMR931225911017', 'Toledo', '2017-03-24', 5, 59, ''),
('MRMR931225911018', 'Toledo', '2017-03-16', 12, 36, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `Codigo_identificacion_medico` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Especialidad` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Numero_colegiado` int(50) NOT NULL,
  `Cargo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Observaciones` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `ID_ingreso` varchar(150) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`Codigo_identificacion_medico`, `Nombre`, `Apellidos`, `Especialidad`, `Numero_colegiado`, `Cargo`, `Observaciones`, `ID_ingreso`) VALUES
('11111111111', 'Blanco', 'Cordero García', 'Medicina familiar', 110703010, 'Medico', '', 'MRMR931225911016'),
('15648geqg', 'Blanca', 'Cordero García', 'Medicina familiar', 110703010, 'Medico', '', 'MRMR931225911016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `n_Seguridad_Social` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Domicilio` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Poblacion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Provincia` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Codigo_postal` int(5) NOT NULL,
  `Numero_telefono` int(9) NOT NULL,
  `Numero_historial_clinico` int(150) NOT NULL,
  `Codigo_identificacion_medico` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Observaciones` varchar(500) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`n_Seguridad_Social`, `Nombre`, `Apellidos`, `Domicilio`, `Poblacion`, `Provincia`, `Codigo_postal`, `Numero_telefono`, `Numero_historial_clinico`, `Codigo_identificacion_medico`, `Observaciones`) VALUES
('MRMR931225911016', 'Jorge', 'Mercado Martin', 'C/Via Tarpeya', 'Toledo', 'Toledo', 45007, 615588926, 512463145, '15648geqg', 'Un tio guay'),
('MRMR931225911017', 'Lucas', 'Pelucas', 'C/Pelos', 'Toledo', 'Toledo', 45007, 615588927, 4546868, '15648geqg', ''),
('MRMR931225911018', 'EnFin', 'Serafin', 'C/Yo con mi Tole Tole', 'Toledo', 'Toledo', 45003, 615588929, 69696971, '11111111111', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ingresos`
--
ALTER TABLE `ingresos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`Codigo_identificacion_medico`),
  ADD KEY `n_Seguridad_Social_Paciente` (`ID_ingreso`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`n_Seguridad_Social`),
  ADD KEY `Codigo_identificacion_medico` (`Codigo_identificacion_medico`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD CONSTRAINT `medicos_ibfk_1` FOREIGN KEY (`ID_ingreso`) REFERENCES `ingresos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD CONSTRAINT `pacientes_ibfk_1` FOREIGN KEY (`n_Seguridad_Social`) REFERENCES `ingresos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pacientes_ibfk_2` FOREIGN KEY (`Codigo_identificacion_medico`) REFERENCES `medicos` (`Codigo_identificacion_medico`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
