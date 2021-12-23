package com.example.petproject.transformer

import com.example.petproject.model.InsuranceContract
import com.example.petproject.model.InsuranceKit
import com.example.petproject.model.dto.InsuranceContractDto
import com.example.petproject.repository.ClientRepository
import com.example.petproject.repository.InsuranceKitRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import javax.persistence.EntityNotFoundException
import kotlin.contracts.contract

@Component
class InsuranceContractTransformer(
    private val clientRepository: ClientRepository,
    private val insuranceKitRepository: InsuranceKitRepository
) {

    fun transform(preference: InsuranceContract) = InsuranceContractDto(
        clientId = preference.owner.id,
        kits = preference.kits.map {it.id}
    )

    fun transform(preference: InsuranceContractDto) = InsuranceContract().apply {
        owner = findClientById(preference.clientId)
        kits = insuranceKitRepository.findByIdIn(preference.kits)
    }

    private fun findClientById(clientId: Long) = clientRepository.findByIdOrNull(clientId)
        ?: throw EntityNotFoundException("Client not found")
}