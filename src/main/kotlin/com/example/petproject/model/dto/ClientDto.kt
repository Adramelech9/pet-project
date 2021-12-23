package com.example.petproject.model.dto

import java.time.LocalDate

data class ClientDto(
    
    val email: String,
    val password: String,
    val birthDate: LocalDate,
    val firstName: String,
    val lastName: String
)