package com.example.petproject.service

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.repository.ClientRepository
import com.example.petproject.repository.ClientRepositoryCustomImpl
import com.example.petproject.transformer.ClientTransformer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDate

@DataJpaTest
internal class ClientServiceTest {

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
        lastName = "first"
    )
    private val dto2 = ClientDto(
        email = "second@mail.com",
        password = "123456",
        birthDate = LocalDate.now(),
        firstName = "second",
        lastName = "second"
    )

    @Test
    fun findShortClients() {
        clientRepository.save(clientTransformer.transform(dto1))
        clientRepository.save(clientTransformer.transform(dto2))
        println(clientRepositoryCustomImpl.findShortClients())
    }
}
