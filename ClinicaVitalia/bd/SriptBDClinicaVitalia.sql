DROP DATABASE IF EXISTS bd_clinica_vitalia;

CREATE DATABASE bd_clinica_vitalia;

USE bd_clinica_vitalia;

CREATE TABLE tb_especialidad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL
);

INSERT INTO tb_especialidad (descripcion) VALUES 
('Pediatría'),
('Cardiología'),
('Dermatología'),
('Ginecología'),
('Oftalmología');

SELECT * FROM tb_especialidad;

CREATE TABLE tb_medico(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    id_especialidad INT,
    email VARCHAR(255) NOT NULL UNIQUE,
    numCel NUMERIC NOT NULL,
    FOREIGN KEY (id_especialidad) REFERENCES tb_especialidad(id)
);

INSERT INTO tb_medico (nombres, apellidos, id_especialidad, email, numCel) VALUES
('Juan', 'González', 1, 'juan.gonzalez@example.com', 923456789),
('María', 'López', 2, 'maria.lopez@example.com', 987654321),
('Carlos', 'Martínez', 3, 'carlos.martinez@example.com', 927358235),
('Laura', 'Rodríguez', 4, 'laura.rodriguez@example.com', 933882572),
('Luis', 'Hernández', 5, 'luis.hernandez@example.com', 999999999);

SELECT * FROM tb_medico;


CREATE TABLE tb_paciente (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apePaterno VARCHAR(100) NOT NULL,
    apeMaterno VARCHAR(100) NOT NULL,
    fechaNac DATE NOT NULL,
    sexo INT,
    email VARCHAR(255) NOT NULL UNIQUE,
    numCel NUMERIC NOT NULL,
    userName VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

INSERT INTO tb_paciente (nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena)
VALUES ('Juan', 'Pérez', 'Gómez', '1990-05-12', 1, 'juan@example.com', 123456789, 'juanito', 'j123');
INSERT INTO tb_paciente (nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena)
VALUES ('María', 'López', 'García', '1988-09-25', 2, 'maria@example.com', 987654321, 'mary', 'm123');
INSERT INTO tb_paciente (nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena)
VALUES ('Carlos', 'Rodríguez', 'Fernández', '1995-03-08', 1, 'carlos@example.com', 555555555, 'carlitos', 'c123');
INSERT INTO tb_paciente (nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena)
VALUES ('Luisa', 'Martínez', 'Sánchez', '1992-11-19', 2, 'luisa@example.com', 777777777, 'lulu', 'l123');
INSERT INTO tb_paciente (nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena)
VALUES ('Andrés', 'González', 'Ramírez', '1985-07-30', 1, 'andres@example.com', 999999999, 'andy', 'a123');

SELECT * FROM tb_paciente;

CREATE TABLE tb_sede(
	id INT AUTO_INCREMENT PRIMARY KEY,
	des_sede VARCHAR(255) NOT NULL
);

INSERT INTO tb_sede(des_sede) VALUES
('Arequipa'),
('Tacna'),
('Lima');

SELECT * FROM tb_sede;


CREATE TABLE tb_TipoConsulta(
	id INT AUTO_INCREMENT PRIMARY KEY,
    des_tipoConsulta VARCHAR(255) NOT NULL
);

INSERT INTO tb_tipoConsulta(des_tipoConsulta) VALUES
	('Presencial'),
    ('Virtual');

SELECT * FROM tb_tipoConsulta;

DROP TABLE IF EXISTS tb_cita;

CREATE TABLE tb_cita(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_medico INT,
    id_especialidad INT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    id_tipoConsulta INT NOT NULL,
    id_sede INT NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES tb_medico(id),
    FOREIGN KEY (id_especialidad) REFERENCES tb_especialidad(id),
    FOREIGN KEY (id_tipoConsulta) REFERENCES tb_tipoConsulta(id),
    FOREIGN KEY (id_sede) REFERENCES tb_sede(id)
);

INSERT INTO tb_cita (id_medico, id_especialidad, fecha, hora, motivo, id_tipoConsulta, id_sede) VALUES
(1, 1, '2023-12-01', '09:00:00', 'Examen de rutina', 1, 1),
(2, 2, '2023-12-03', '10:30:00', 'Control de presión arterial', 2, 2),
(3, 1, '2023-12-05', '15:45:00', 'Consulta por alergia', 1, 1),
(4, 2, '2023-12-07', '11:15:00', 'Revisión de ojos', 2, 2),
(5, 1, '2023-12-10', '14:00:00', 'Chequeo general', 1, 1);


SELECT * FROM tb_cita;

