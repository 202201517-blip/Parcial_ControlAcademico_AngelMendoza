package com.example.Parcial_ControlAcademico_AngelMendoza.repository

import com.example.Parcial_ControlAcademico_AngelMendoza.entity.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlumnoRepository : JpaRepository<Alumno, Int>