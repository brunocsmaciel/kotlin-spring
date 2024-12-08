package github.macices.kotlin.spring.dto

data class PersonInputDto(
    val firstName: String,
    val lastName: String,
    val address: String,
    val gender: String
)