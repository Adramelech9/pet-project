package com.example.petproject.service

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.repository.ClientRepository
import com.example.petproject.repository.ClientRepositoryCustomImpl
import com.example.petproject.transformer.ClientTransformer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate

internal class ClientServiceTest : BaseRepositoryTest() {

    @Autowired
    private lateinit var clientRepository: ClientRepository

    @Autowired
    private lateinit var clientRepositoryCustomImpl: ClientRepositoryCustomImpl
    private var clientTransformer = ClientTransformer()
    private val clientService by lazy {
        ClientService(
            clientRepository,
            clientRepositoryCustomImpl,
            clientTransformer
        )
    }

    private val dto1 = ClientDto(
        email = "first@mail.com",
        password = "123456",
        birthDate = LocalDate.now(),
        firstName = "first",
        lastName = "first2"
    )
    private val dto2 = ClientDto(
        email = "second@mail.com",
        password = "123456",
        birthDate = LocalDate.now(),
        firstName = "second",
        lastName = "second2"
    )

    fun saveClient(vararg dto: ClientDto) {
        for (el in dto) {
            clientRepository.save(clientTransformer.transform(el))
        }
    }

    @Test
    fun findShortClients() {
        saveClient(dto1, dto2)
        assertEquals(clientRepositoryCustomImpl.findShortClients()[1].firstName, dto2.firstName)
        assertEquals(clientRepositoryCustomImpl.findShortClients()[1].lastName, dto2.lastName)
    }
}
