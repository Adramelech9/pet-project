package com.example.petproject.transformer

import com.example.petproject.model.InsuranceKit
import com.example.petproject.model.dto.InsuranceKitDto
import org.springframework.stereotype.Component

@Component
class InsuranceKitTransformer {

    fun transform(preference: InsuranceKit) = InsuranceKitDto(
        duration = preference.duration,
        compensationPercent = preference.compensationPercent,
        damageLevel = preference.damageLevel,
        coveredPart = preference.coveredPart
    )

    fun transform(preference: InsuranceKitDto) = InsuranceKit().apply {
        duration = preference.duration
        compensationPercent = preference.compensationPercent
        damageLevel = preference.damageLevel
        coveredPart = preference.coveredPart
    }
}
