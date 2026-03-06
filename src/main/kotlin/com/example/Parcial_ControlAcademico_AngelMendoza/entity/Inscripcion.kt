package com.example.Parcial_ControlAcademico_AngelMendoza.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "inscripcion")
class Inscripcion(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    var idInscripcion: Int? = null,

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    var alumno: Alumno,

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    var curso: Curso,

    @Column(name = "fecha_inscripcion", nullable = false)
    var fechaInscripcion: LocalDate
)