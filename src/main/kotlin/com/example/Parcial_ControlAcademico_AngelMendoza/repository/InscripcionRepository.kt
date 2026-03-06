package com.example.Parcial_ControlAcademico_AngelMendoza.repository

import com.example.Parcial_ControlAcademico_AngelMendoza.entity.Inscripcion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscripcionRepository : JpaRepository<Inscripcion, Int>