package com.example.petproject.model.dto

import com.example.petproject.model.CoveredPart
import com.example.petproject.model.DamageLevel
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

data class InsuranceKitDto(
    @field:NotEmpty
    val duration: LocalDateTime,
    @field:NotEmpty
    val compensationPercent: Int,
    @field:NotEmpty
    val damageLevel: DamageLevel,
    @field:NotEmpty
    val coveredPart: CoveredPart
)
