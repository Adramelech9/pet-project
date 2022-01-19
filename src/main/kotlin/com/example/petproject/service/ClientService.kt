package com.example.petproject.service

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.repository.ClientRepository
import com.example.petproject.repository.ClientRepositoryCustomImpl
import com.example.petproject.transformer.ClientTransformer
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientRepositoryCustomImpl: ClientRepositoryCustomImpl,
    private val clientTransformer: ClientTransformer
) {

    fun addClient(clientDto: ClientDto) =
        clientRepository.save(clientTransformer.transform(clientDto)).id

    fun findShortClients() =
        clientRepositoryCustomImpl.findShortClients()

    fun showClientById(id: Long): ClientDto =
        clientTransformer.transform(clientRepository.findById(id).orElseThrow())
}

