package com.example.petproject.controller

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.service.ClientService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
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
    private val invalidDto = ClientDto(
        email = "",
        password = "",
        birthDate = LocalDate.of(1, 2, 22),
        firstName = "",
        lastName = ""
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
        mockMvc.perform(
            MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(validDto))
        ).andExpect(status().isOk)
    }

    @Test
    fun `add new valid client without dto`() {
        mockMvc.post(path) {
            param("email", "2@fmail.com")
            param("password", "123456")
            param("birthDate", "2000-01-02")
            param("firstName", "Din")
            param("lastName", "Don")
        }.andExpect { status().is3xxRedirection }
    }

    @Test
    fun `add new invalid client`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(invalidDto))
        ).andExpect(status().is4xxClientError)
    }

    @Test
    fun `add new invalid client without dto`() {
        mockMvc.post(path) {
            param("email", "")
            param("password", "")
            param("birthDate", "2000-01-02")
            param("firstName", "")
            param("lastName", "")
        }.andExpect { status().is4xxClientError }
    }

    @ParameterizedTest
    @EmptySource
    fun `add new client with empty email`(email: String) {
        mockMvc.post(path) {
            param("email", email)
            param("password", "123456")
            param("birthDate", "2000-01-02")
            param("firstName", "Dio")
            param("lastName", "Maria")
        }.andExpect { status().is4xxClientError }
    }
}
