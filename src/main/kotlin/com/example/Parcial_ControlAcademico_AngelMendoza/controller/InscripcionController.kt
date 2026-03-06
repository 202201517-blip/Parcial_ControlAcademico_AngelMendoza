package com.example.Parcial_ControlAcademico_AngelMendoza.controller

import com.example.Parcial_ControlAcademico_AngelMendoza.dto.InscripcionRequest
import com.example.Parcial_ControlAcademico_AngelMendoza.entity.Inscripcion
import com.example.Parcial_ControlAcademico_AngelMendoza.repository.AlumnoRepository
import com.example.Parcial_ControlAcademico_AngelMendoza.repository.CursoRepository
import com.example.Parcial_ControlAcademico_AngelMendoza.repository.InscripcionRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/inscripciones")
class InscripcionController(
    private val inscripcionRepository: InscripcionRepository,
    private val alumnoRepository: AlumnoRepository,
    private val cursoRepository: CursoRepository
) {

    @GetMapping
    fun obtenerTodas(): List<Inscripcion> {
        return inscripcionRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<Inscripcion> {
        val inscripcion = inscripcionRepository.findById(id)
        return if (inscripcion.isPresent) {
            ResponseEntity.ok(inscripcion.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun crear(@RequestBody request: InscripcionRequest): ResponseEntity<Any> {
        val alumno = alumnoRepository.findById(request.idAlumno)
        val curso = cursoRepository.findById(request.idCurso)

        if (alumno.isEmpty || curso.isEmpty) {
            return ResponseEntity.badRequest().body("Alumno o curso no encontrado")
        }

        val inscripcion = Inscripcion(
            alumno = alumno.get(),
            curso = curso.get(),
            fechaInscripcion = LocalDate.parse(request.fechaInscripcion)
        )

        return ResponseEntity.ok(inscripcionRepository.save(inscripcion))
    }

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Int, @RequestBody request: InscripcionRequest): ResponseEntity<Any> {
        val inscripcionExistente = inscripcionRepository.findById(id)
        val alumno = alumnoRepository.findById(request.idAlumno)
        val curso = cursoRepository.findById(request.idCurso)

        if (inscripcionExistente.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        if (alumno.isEmpty || curso.isEmpty) {
            return ResponseEntity.badRequest().body("Alumno o curso no encontrado")
        }

        val inscripcion = inscripcionExistente.get()
        inscripcion.alumno = alumno.get()
        inscripcion.curso = curso.get()
        inscripcion.fechaInscripcion = LocalDate.parse(request.fechaInscripcion)

        return ResponseEntity.ok(inscripcionRepository.save(inscripcion))
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Int): ResponseEntity<Void> {
        val inscripcionExistente = inscripcionRepository.findById(id)

        return if (inscripcionExistente.isPresent) {
            inscripcionRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}