package com.example.Parcial_ControlAcademico_AngelMendoza.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "alumno")
class Alumno(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    var idAlumno: Int? = null,

    @Column(name = "nombre", nullable = false, length = 100)
    var nombre: String,

    @Column(name = "apellido", nullable = false, length = 100)
    var apellido: String,

    @Column(name = "carnet", nullable = false, unique = true, length = 20)
    var carnet: String,

    @Column(name = "correo", nullable = false, length = 150)
    var correo: String,

    @Column(name = "activo", nullable = false)
    var activo: Boolean
)