package com.example.petproject.transformer

import com.example.petproject.model.InsuranceKit
import com.example.petproject.model.dto.InsuranceKitDto
import org.springframework.stereotype.Component

@Component
class InsuranceKitTransformer {

    fun transform(entity: InsuranceKit) = InsuranceKitDto(
        duration = entity.duration,
        compensationPercent = entity.compensationPercent,
        damageLevel = entity.damageLevel,
        coveredPart = entity.coveredPart
    )

    fun transform(dto: InsuranceKitDto) = InsuranceKit().apply {
        duration = dto.duration
        compensationPercent = dto.compensationPercent
        damageLevel = dto.damageLevel
        coveredPart = dto.coveredPart
    }
}
