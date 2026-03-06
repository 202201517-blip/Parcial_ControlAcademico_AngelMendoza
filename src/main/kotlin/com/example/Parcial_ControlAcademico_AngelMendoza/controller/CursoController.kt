package com.example.Parcial_ControlAcademico_AngelMendoza.controller

import com.example.Parcial_ControlAcademico_AngelMendoza.entity.Curso
import com.example.Parcial_ControlAcademico_AngelMendoza.repository.CursoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cursos")
class CursoController(
    private val cursoRepository: CursoRepository
) {

    @GetMapping
    fun obtenerTodos(): List<Curso> {
        return cursoRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<Curso> {
        val curso = cursoRepository.findById(id)
        return if (curso.isPresent) {
            ResponseEntity.ok(curso.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun crear(@RequestBody curso: Curso): Curso {
        return cursoRepository.save(curso)
    }

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Int, @RequestBody cursoActualizado: Curso): ResponseEntity<Curso> {
        val cursoExistente = cursoRepository.findById(id)

        return if (cursoExistente.isPresent) {
            val curso = cursoExistente.get()
            curso.nombre = cursoActualizado.nombre
            curso.codigo = cursoActualizado.codigo
            curso.creditos = cursoActualizado.creditos

            ResponseEntity.ok(cursoRepository.save(curso))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Int): ResponseEntity<Void> {
        val cursoExistente = cursoRepository.findById(id)

        return if (cursoExistente.isPresent) {
            cursoRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}