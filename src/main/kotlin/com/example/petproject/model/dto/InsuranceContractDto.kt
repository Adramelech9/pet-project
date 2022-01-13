package com.example.petproject.model.dto

import javax.validation.constraints.NotEmpty

data class InsuranceContractDto(

    @field:NotEmpty
    val kits: List<Long>,
    @field:NotEmpty
    val clientId: Long
)
