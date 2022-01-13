package com.example.petproject.model.dto

import com.example.petproject.model.CoveredPart
import com.example.petproject.model.DamageLevel
import java.time.LocalDateTime

data class InsuranceKitDto (
    val duration: LocalDateTime,
    val compensationPercent: Int,
    val damageLevel: DamageLevel,
    val coveredPart: CoveredPart
)