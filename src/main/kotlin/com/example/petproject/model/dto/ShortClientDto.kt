package com.example.petproject.model.dto

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class ShortClientDto(

    @field:NotNull
    @field:Min(1)
    val id: Long,
    @field:NotBlank
    @field:Size(min = 3)
    val firstName: String,
    @field:NotBlank
    @field:Size(min = 3)
    val lastName: String
)
