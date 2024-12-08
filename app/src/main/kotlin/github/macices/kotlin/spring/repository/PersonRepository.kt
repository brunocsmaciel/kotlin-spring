package github.macices.kotlin.spring.repository

import github.macices.kotlin.spring.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Long> {
}