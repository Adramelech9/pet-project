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
        if (insuranceKitRepository.countInsuranceKit() <= 2)
            insuranceKitRepository.save(insuranceKitTransformer.transform(insuranceKitDto))
        else throw Error("too many kits, cannot be more than 3")
    }
}