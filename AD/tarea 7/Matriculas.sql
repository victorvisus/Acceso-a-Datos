CREATE TABLE IF NOT EXISTS matriculas (
  DNI varchar(9) NOT NULL,
  NombreModulo varchar(60) NOT NULL,
  Curso varchar(5) NOT NULL,
  Nota double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

INSERT INTO matriculas (DNI, NombreModulo, Curso, Nota) VALUES
('12345678A', 'Acceso a datos', '22-23', 8),
('12345678A', 'Desarrollo de Interfaces', '22-23', 9.5),
('14785236d', 'Acceso a datos', '22-23', 7),
('14785236d', 'Desarrollo de Interfaces', '22-23', 7.5);
