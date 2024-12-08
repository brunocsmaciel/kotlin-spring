package github.macices.kotlin.spring

import github.macices.kotlin.spring.dto.PersonInputDto
import github.macices.kotlin.spring.dto.PersonUpdateDto
import github.macices.kotlin.spring.model.Person

fun PersonInputDto.toDomain(): Person {
    return Person(
        firstName = this.firstName,
        lastName = this.lastName,
        address = this.address,
        gender = this.gender
    )
}

fun PersonUpdateDto.toDomain(): Person {
    return Person(
        firstName = this.firstName,
        address = this.address,
        gender = this.gender
    )
}
