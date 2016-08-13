SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `colegioweb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `colegioweb`;

CREATE TABLE `administrador` (
  `usuario` varchar(40) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `administrador` (`usuario`, `nombres`, `password`) VALUES
('raulgf02', 'Raul Larriega Gallegos', 'eureka');

CREATE TABLE `alumnos` (
  `usuario` varchar(30) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `matriculado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `alumnos` (`usuario`, `nombres`, `apellidos`, `email`, `password`, `matriculado`) VALUES
('asd', 'asd', 'asd', 'asd@asd', 'asd', 'no'),
('josue14', 'Josue Francisco', 'Carbajo Gallegos', 'josueCarbajo@hotmail.com', 'hola', 'no'),
('raulgf02', 'Raul ', 'Larriega Gallegos', 'raulgf@hotmail.com', 'apple', 'no'),
('spark119                      ', 'Gianfranco', 'Ortiz Sierra', 'sparkz119@gmail.com', 'spark119', 'no'),
('yeli19', 'Yelitza', 'Larriega Gallegos', 'ylarriega@hotmail.com', 'sebas', 'no');

CREATE TABLE `curso` (
  `codigo` varchar(10) NOT NULL,
  `nombre` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `curso` (`codigo`, `nombre`) VALUES
('C001', 'Arte'),
('C002', 'Anatomia'),
('C003', 'Biologia'),
('C004', 'Ciencia y Ambiente'),
('C005', 'Algebra'),
('C006', 'Trigonometria'),
('C007', 'Comunicacion'),
('C008', 'Historia');
CREATE TABLE `cursosasignados` (
`idProfesorCurso` int(11)
,`codigoProfesor` varchar(40)
,`nombres` varchar(40)
,`grado` varchar(10)
,`codigoCurso` varchar(10)
);

CREATE TABLE `matriculados` (
  `codigoMatricula` varchar(10) NOT NULL,
  `usuario` varchar(25) NOT NULL,
  `grado` varchar(10) NOT NULL,
  `anio` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `matriculadoscurso` (
  `codigoMatricula` varchar(30) NOT NULL,
  `idProfCurso` int(11) NOT NULL,
  `registroNotas` varchar(10) NOT NULL DEFAULT 'no',
  `promPrac` double NOT NULL DEFAULT '0',
  `promTrab` double NOT NULL DEFAULT '0',
  `examParcial` double NOT NULL DEFAULT '0',
  `examFinal` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `profesor` (
  `usuario` varchar(40) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `estudios` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `profesor` (`usuario`, `nombres`, `dni`, `estudios`, `password`) VALUES
('FelipeGenial', 'Felipe', '81287157', 'MaestrÃ­a', '123123'),
('mateoG55', 'Mateo Gallegos Gallegos', '72923852', 'Postgrado', 'mate');

CREATE TABLE `profesorcurso` (
  `idProfesorCurso` int(11) NOT NULL,
  `codigoProfesor` varchar(40) NOT NULL,
  `codigoCurso` varchar(10) NOT NULL,
  `grado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `profesorcurso` (`idProfesorCurso`, `codigoProfesor`, `codigoCurso`, `grado`) VALUES
(220, 'mateoG55', 'C003', '5'),
(221, 'FelipeGenial', 'C001', '1'),
(224, 'FelipeGenial', 'C002', '1'),
(225, 'FelipeGenial', 'C003', '1'),
(226, 'FelipeGenial', 'C004', '1'),
(227, 'FelipeGenial', 'C005', '1'),
(228, 'FelipeGenial', 'C006', '1'),
(233, 'FelipeGenial', 'C007', '1'),
(234, 'FelipeGenial', 'C008', '1'),
(235, 'mateoG55', 'C001', '2'),
(237, 'mateoG55', 'C002', '2');
CREATE TABLE `profesorcursovista` (
`idProfesorCurso` int(11)
,`codigoProfesor` varchar(40)
,`nombres` varchar(40)
,`grado` varchar(10)
,`codigo` varchar(10)
,`nombre` varchar(40)
);
DROP TABLE IF EXISTS `cursosasignados`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cursosasignados`  AS  select `a`.`idProfesorCurso` AS `idProfesorCurso`,`a`.`codigoProfesor` AS `codigoProfesor`,`b`.`nombres` AS `nombres`,`a`.`grado` AS `grado`,`a`.`codigoCurso` AS `codigoCurso` from (`profesorcurso` `a` join `profesor` `b` on((`a`.`codigoProfesor` = `b`.`usuario`))) order by `a`.`grado`,`a`.`codigoCurso` ;
DROP TABLE IF EXISTS `profesorcursovista`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `profesorcursovista`  AS  select `a`.`idProfesorCurso` AS `idProfesorCurso`,`a`.`codigoProfesor` AS `codigoProfesor`,`b`.`nombres` AS `nombres`,`a`.`grado` AS `grado`,`c`.`codigo` AS `codigo`,`c`.`nombre` AS `nombre` from ((`profesorcurso` `a` join `profesor` `b` on((`a`.`codigoProfesor` = `b`.`usuario`))) join `curso` `c` on((`a`.`codigoCurso` = `c`.`codigo`))) ;


ALTER TABLE `administrador`
  ADD PRIMARY KEY (`usuario`);

ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`usuario`);

ALTER TABLE `curso`
  ADD PRIMARY KEY (`codigo`);

ALTER TABLE `matriculados`
  ADD PRIMARY KEY (`codigoMatricula`),
  ADD UNIQUE KEY `codigoMatricula` (`codigoMatricula`,`usuario`),
  ADD KEY `usuario` (`usuario`);

ALTER TABLE `matriculadoscurso`
  ADD KEY `codigoMatricula` (`codigoMatricula`),
  ADD KEY `idProfCurso` (`idProfCurso`);

ALTER TABLE `profesor`
  ADD PRIMARY KEY (`usuario`),
  ADD UNIQUE KEY `dni` (`dni`);

ALTER TABLE `profesorcurso`
  ADD PRIMARY KEY (`idProfesorCurso`),
  ADD UNIQUE KEY `codigoCurso_2` (`codigoCurso`,`grado`),
  ADD KEY `codigoProfesor` (`codigoProfesor`),
  ADD KEY `codigoCurso` (`codigoCurso`);


ALTER TABLE `profesorcurso`
  MODIFY `idProfesorCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=238;

ALTER TABLE `matriculados`
  ADD CONSTRAINT `matriculados_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `alumnos` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `matriculadoscurso`
  ADD CONSTRAINT `matriculadoscurso_ibfk_1` FOREIGN KEY (`codigoMatricula`) REFERENCES `matriculados` (`codigoMatricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `matriculadoscurso_ibfk_2` FOREIGN KEY (`idProfCurso`) REFERENCES `profesorcurso` (`idProfesorCurso`) ON UPDATE CASCADE;

ALTER TABLE `profesorcurso`
  ADD CONSTRAINT `profesorcurso_ibfk_1` FOREIGN KEY (`codigoProfesor`) REFERENCES `profesor` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `profesorcurso_ibfk_2` FOREIGN KEY (`codigoCurso`) REFERENCES `curso` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
