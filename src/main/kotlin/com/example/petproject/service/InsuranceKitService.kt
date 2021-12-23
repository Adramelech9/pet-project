package com.example.petproject.service

import com.example.petproject.model.dto.InsuranceKitDto
import com.example.petproject.repository.InsuranceKitRepository
import com.example.petproject.transformer.InsuranceKitTransformer
import org.springframework.stereotype.Service

@Service
class InsuranceKitService(
    private val insuranceKitRepository: InsuranceKitRepository,
    private val insuranceKitTransformer: InsuranceKitTransformer
) {

    fun addKit(insuranceKitDto: InsuranceKitDto) {
        insuranceKitRepository.save(insuranceKitTransformer.transform(insuranceKitDto))
    }
}