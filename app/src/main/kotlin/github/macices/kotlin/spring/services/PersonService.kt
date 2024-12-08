package github.macices.kotlin.spring.services

import github.macices.kotlin.spring.exceptions.ResourceNotFoundException
import github.macices.kotlin.spring.model.Person
import github.macices.kotlin.spring.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService(
    private val repository: PersonRepository
) {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findOrFail(id: Long): Person {
        logger.info("Finding a person with id = $id!")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person with id = $id not found") }
    }

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        return repository.findAll()
    }

    fun create(person: Person): Person {
        logger.info("Creating one persoon with name ${person.firstName}")
        return repository.save(person)
    }

    fun update(id: Long, person: Person): Person {
        // TODO ajustar essa busca e a logica para atualizar. E se o person chegar com alguns campos nulos? Da forma
        // TODO como esta ele ira sobreescrever e salvar o personToSave com propriedades ""
        val entity = findOrFail(id)

        val personToSave = entity.copy(
            firstName = person.firstName,
            address = person.address,
            gender = person.gender
        )
        return repository.save(personToSave)
    }

    fun delete(id: Long) {
        val entity = findOrFail(id)
        repository.delete(entity)
    }
}