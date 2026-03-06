package com.example.Parcial_ControlAcademico_AngelMendoza.dto

data class InscripcionRequest(
    val idAlumno: Int,
    val idCurso: Int,
    val fechaInscripcion: String
)