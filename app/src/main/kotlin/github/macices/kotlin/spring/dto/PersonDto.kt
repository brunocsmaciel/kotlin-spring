package github.macices.kotlin.spring.dto

import github.macices.kotlin.spring.model.Person

data class PersonDto(
    val firstName: String,
    val lastName: String,
    val address: String,
    val gender: String
) {
    constructor(person: Person) : this(
        firstName = person.firstName,
        lastName = person.lastName,
        address = person.address,
        gender = person.gender
    )
}