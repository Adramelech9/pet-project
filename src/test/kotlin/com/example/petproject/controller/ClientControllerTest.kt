package com.example.petproject.controller

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.service.ClientService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.aggregator.ArgumentsAccessor
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

@WebMvcTest(ClientController::class)
internal class ClientControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @MockBean
    private lateinit var clientService: ClientService

    private var path = "/api/clients"
    private var validDto = ClientDto(
        email = "2@fmail.com",
        password = "123456",
        birthDate = LocalDate.of(2000, 2, 22),
        firstName = "name",
        lastName = "name"
    )
    private val shortFirstName = ClientDto(
        email = "2@fmail.com",
        password = "123456",
        birthDate = LocalDate.of(2000, 2, 22),
        firstName = "name",
        lastName = "n"
    )
    private val shortLastName = ClientDto(
        email = "2@fmail.com",
        password = "123456",
        birthDate = LocalDate.of(2000, 2, 22),
        firstName = "n",
        lastName = "name"
    )
    private val birthDateFromTheFuture = ClientDto(
        email = "2@fmail.com",
        password = "123456",
        birthDate = LocalDate.of(2222, 2, 22),
        firstName = "name",
        lastName = "name"
    )
    private val shortPassword = ClientDto(
        email = "2@fmail.com",
        password = "1",
        birthDate = LocalDate.of(2000, 2, 22),
        firstName = "name",
        lastName = "n"
    )
    private val invalidEmail = ClientDto(
        email = "2email",
        password = "123456",
        birthDate = LocalDate.of(2000, 2, 22),
        firstName = "name",
        lastName = "n"
    )

    @Test
    fun `get client`() {
        mockMvc.get(path)
            .andExpect { status().isOk }
    }

    @Test
    fun `find client`() {
        mockMvc.get("$path/e")
            .andExpect { status().isOk }
    }

    @Test
    fun `add new valid client`() {
        sendDto(validDto).andExpect(status().isOk)
    }

    @Test
    fun `add new client with short firstName`() {
        sendDto(shortFirstName).andExpect(status().is4xxClientError)
    }

    @Test
    fun `add new client with short lastName`() {
        sendDto(shortLastName).andExpect(status().is4xxClientError)
    }

    @Test
    fun `add new client from the future birthDate`() {
        sendDto(birthDateFromTheFuture).andExpect(status().is4xxClientError)
    }

    @Test
    fun `add new client with short password`() {
        sendDto(shortPassword).andExpect(status().is4xxClientError)
    }

    @Test
    fun `add new client with invalid email`() {
        sendDto(invalidEmail).andExpect(status().is4xxClientError)
    }

    private fun sendDto(dto: ClientDto): ResultActions {
        return mockMvc.perform(
            MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(dto))
        )
    }

    @ParameterizedTest
    @CsvSource("1@mail, 123456, 2000-01-02, Dio, Maria")
    fun `add new client`(argumentsAccessor: ArgumentsAccessor) {
        val dto = ClientDto(
            email = argumentsAccessor.getString(0),
            password = argumentsAccessor.getString(1),
            birthDate = LocalDate.parse(argumentsAccessor.getString(2)),
            firstName = argumentsAccessor.getString(3),
            lastName = argumentsAccessor.getString(4)
        )
        sendDto(dto).andExpect(status().isOk)
    }

    @ParameterizedTest
    @CsvSource("1@mail, 123456, 2000-01-02, '', Maria")
    fun `add new client without firstName`(argumentsAccessor: ArgumentsAccessor) {
        val dto = ClientDto(
            email = argumentsAccessor.getString(0),
            password = argumentsAccessor.getString(1),
            birthDate = LocalDate.parse(argumentsAccessor.getString(2)),
            firstName = argumentsAccessor.getString(3),
            lastName = argumentsAccessor.getString(4)
        )
        sendDto(dto).andExpect(status().is4xxClientError)
    }
}
