package com.example.petproject.service

import com.example.petproject.model.CoveredPart
import com.example.petproject.model.DamageLevel
import com.example.petproject.model.dto.InsuranceKitDto
import com.example.petproject.repository.InsuranceKitRepository
import com.example.petproject.transformer.InsuranceKitTransformer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime

@DataJpaTest
internal class InsuranceKitServiceTest {

    @Autowired
    private lateinit var insuranceKitRepository: InsuranceKitRepository
    private val insuranceKitTransformer = InsuranceKitTransformer()
    private val insuranceKitService by lazy {
        InsuranceKitService(
            insuranceKitRepository,
            insuranceKitTransformer
        )
    }

    private val dto = InsuranceKitDto(
        duration = LocalDateTime.now(),
        compensationPercent = 50,
        damageLevel = DamageLevel.MEDIUM,
        coveredPart = CoveredPart.WIND_SCREEN
    )

    @Test
    fun `add new kit`() {
        // Setup
        saveKits(2)
        // Execute
        insuranceKitService.addKit(dto)
        // Verify
        assertEquals(insuranceKitRepository.countKits(), 3)
    }

    @Test
    fun `add new kit with max count`() {
        assertThrows<Error> {
            saveKits(3)
            insuranceKitService.addKit(dto)
        }
    }

    private fun saveKits(count: Int) {
        (1..count).forEach {
            insuranceKitRepository.save(insuranceKitTransformer.transform(dto))
        }
    }

}

