package com.example.petproject.service

import com.example.petproject.model.Client
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

    fun showAllClients(client: Client) {
        transform(client)
        clientRepository.findName()
    }

    fun showClients(client: Client, id: Int) {
        transform(client)
        clientRepository.findClientById(id)
    }

    fun transform(client: Client) = clientTransformer.transform(client)
}

