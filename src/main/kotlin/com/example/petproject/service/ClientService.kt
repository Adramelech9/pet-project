package com.example.petproject.service

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.repository.ClientRepository
import com.example.petproject.transformer.ClientTransformer
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientTransformer: ClientTransformer
) {
    fun addClient(clientDto: ClientDto) =
        clientRepository.save(clientTransformer.transform(clientDto))

    fun showAllClients(): List<String> {
        return clientRepository.findAllName()
    }

    fun showClients(id: Long): ClientDto {
        return clientTransformer.transform(clientRepository.findClientById(id))
    }
}

