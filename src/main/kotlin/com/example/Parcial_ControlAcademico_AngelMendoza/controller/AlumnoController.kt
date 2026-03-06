package com.example.Parcial_ControlAcademico_AngelMendoza.controller

import com.example.Parcial_ControlAcademico_AngelMendoza.entity.Alumno
import com.example.Parcial_ControlAcademico_AngelMendoza.repository.AlumnoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/alumnos")
class AlumnoController(
    private val alumnoRepository: AlumnoRepository
) {

    @GetMapping
    fun obtenerTodos(): List<Alumno> {
        return alumnoRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<Alumno> {
        val alumno = alumnoRepository.findById(id)
        return if (alumno.isPresent) {
            ResponseEntity.ok(alumno.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun crear(@RequestBody alumno: Alumno): Alumno {
        return alumnoRepository.save(alumno)
    }

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Int, @RequestBody alumnoActualizado: Alumno): ResponseEntity<Alumno> {
        val alumnoExistente = alumnoRepository.findById(id)

        return if (alumnoExistente.isPresent) {
            val alumno = alumnoExistente.get()
            alumno.nombre = alumnoActualizado.nombre
            alumno.apellido = alumnoActualizado.apellido
            alumno.carnet = alumnoActualizado.carnet
            alumno.correo = alumnoActualizado.correo
            alumno.activo = alumnoActualizado.activo

            ResponseEntity.ok(alumnoRepository.save(alumno))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Int): ResponseEntity<Void> {
        val alumnoExistente = alumnoRepository.findById(id)

        return if (alumnoExistente.isPresent) {
            alumnoRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}