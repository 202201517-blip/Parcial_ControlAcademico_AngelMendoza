package com.example.Parcial_ControlAcademico_AngelMendoza.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "curso")
class Curso(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    var idCurso: Int? = null,

    @Column(name = "nombre", nullable = false, length = 150)
    var nombre: String,

    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    var codigo: String,

    @Column(name = "creditos", nullable = false)
    var creditos: Int
)