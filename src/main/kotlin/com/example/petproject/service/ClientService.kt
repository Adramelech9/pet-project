package com.example.petproject.service

import com.example.petproject.model.dto.ShortClientDto
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
        clientRepository.save(clientTransformer.transform(clientDto)).id

    fun showAllClients(): List<ShortClientDto> =
         clientRepository.findAll().map { clientTransformer.transformAllClients(it) }

    fun showClientById(id: Long): ClientDto {
        return clientTransformer.transform(clientRepository.findClientById(id))
    }
}

