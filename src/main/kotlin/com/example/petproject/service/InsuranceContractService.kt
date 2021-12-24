package com.example.petproject.service

import com.example.petproject.model.dto.InsuranceContractDto
import com.example.petproject.repository.InsuranceContractRepository
import com.example.petproject.transformer.InsuranceContractTransformer
import org.springframework.stereotype.Service

@Service
class InsuranceContractService(
    private val insuranceContractRepository: InsuranceContractRepository,
    private val insuranceContractTransformer: InsuranceContractTransformer
) {
    fun addContract(insuranceContractDto: InsuranceContractDto) {
        if (insuranceContractDto.kits.size < 3)
            insuranceContractRepository.save(insuranceContractTransformer.transform(insuranceContractDto))
        else throw Error("too many kits, cannot be more than 3")
    }
}