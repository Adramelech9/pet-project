package com.example.petproject.model.dto

import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past
import javax.validation.constraints.Size

data class ClientDto(

    @field:NotBlank
    @field:Email
    @field:Size(max = 255)
    val email: String,
    @field:NotBlank
    @field:Size(min = 6, max = 255)
    val password: String,
    @field:NotBlank
    @field:Past
    val birthDate: LocalDate,
    @field:NotBlank
    @field:Size(min = 3, max = 255)
    val firstName: String,
    @field:NotBlank
    @field:Size(min = 3, max = 255)
    val lastName: String
)
