package github.macices.kotlin.spring.controller

import github.macices.kotlin.spring.dto.PersonDto
import github.macices.kotlin.spring.dto.PersonInputDto
import github.macices.kotlin.spring.dto.PersonUpdateDto
import github.macices.kotlin.spring.services.PersonService
import github.macices.kotlin.spring.toDomain
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(val personService: PersonService) {

    @GetMapping("/{id}")
    fun buscaPessoa(@PathVariable id: Long): PersonDto {
        val person = personService.findOrFail(id)
        return PersonDto(person)
    }

    @GetMapping
    fun findAll(): List<PersonDto> {
        val people = personService.findAll()
        return people.map { PersonDto(it) }
    }

    @PostMapping
    fun create(@RequestBody person: PersonInputDto): ResponseEntity<Void> {
        personService.create(person.toDomain())
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody person: PersonUpdateDto
    ): PersonDto {
        val person = personService.update(id, person.toDomain())
        return PersonDto(person)
    }

    @DeleteMapping("/{id}")
    fun apagarPessoa(@PathVariable id: Long): ResponseEntity<Void> {
        personService.delete(id)
        return ResponseEntity.noContent().build()
    }
}