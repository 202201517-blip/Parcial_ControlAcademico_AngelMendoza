package com.example.Parcial_ControlAcademico_AngelMendoza.repository

import com.example.Parcial_ControlAcademico_AngelMendoza.entity.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository : JpaRepository<Curso, Int>