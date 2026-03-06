CREATE DATABASE control_academico;

-- Ejecutar las siguientes sentencias dentro de la base de datos control_academico

CREATE TABLE alumno (
    id_alumno INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    carnet VARCHAR(20) NOT NULL UNIQUE,
    correo VARCHAR(150) NOT NULL,
    activo BOOLEAN NOT NULL
);

CREATE TABLE curso (
    id_curso INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    creditos INTEGER NOT NULL
);

CREATE TABLE inscripcion (
    id_inscripcion INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_alumno INTEGER NOT NULL,
    id_curso INTEGER NOT NULL,
    fecha_inscripcion DATE NOT NULL,
    CONSTRAINT fk_inscripcion_alumno
        FOREIGN KEY (id_alumno) REFERENCES alumno(id_alumno),
    CONSTRAINT fk_inscripcion_curso
        FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
);

INSERT INTO alumno (nombre, apellido, carnet, correo, activo) VALUES
    ('Angel', 'Mendoza', 'AM001', 'angel.mendoza@example.com', TRUE),
    ('Maria', 'Lopez', 'ML002', 'maria.lopez@example.com', TRUE),
    ('Carlos', 'Ramirez', 'CR003', 'carlos.ramirez@example.com', FALSE);

INSERT INTO curso (nombre, codigo, creditos) VALUES
    ('Base de Datos', 'BD101', 4),
    ('Programacion Web', 'PW201', 5),
    ('Matematica', 'MAT110', 3);

INSERT INTO inscripcion (id_alumno, id_curso, fecha_inscripcion) VALUES
    (1, 1, '2026-03-01'),
    (1, 2, '2026-03-02'),
    (2, 1, '2026-03-03'),
    (3, 3, '2026-03-04');