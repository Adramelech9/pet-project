package com.example.petproject.controller

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.repository.ClientRepository
import com.example.petproject.service.ClientService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

@WebMvcTest(ClientController::class)
internal class ClientControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var clientRepository: ClientRepository

    @MockBean
    private lateinit var clientService: ClientService

    val validDto = ClientDto(
        email = "2@fmail.com",
        password = "123456",
        birthDate = LocalDate.of(2000, 2, 22),
        firstName = "name",
        lastName = "name"
    )

    @Test
    fun `get client`() {
        mockMvc.get("/api/clients")
            .andExpect { status().isOk }
    }

    @Test
    fun `find client`() {
        mockMvc.perform(get("/api/clients/2"))
            .andExpect(status().isOk)
        mockMvc.get("/api/clients/e")
            .andExpect { status().isOk }
    }

    @Test
    fun `add new valid client`() {
        mockMvc.post("/api/clients") {

            param("email", "2@fmail.com")
            param("password", "123456")
            param("birthDate", "2000-01-02")
            param("firstName", "Din")
            param("lastName", "Don")
        }.andExpect { status().is3xxRedirection }
    }

    @Test
    fun `add new invalid client`() {
        mockMvc.post("/api/clients") {
            param("email", "")
            param("password", "")
            param("birthDate", "2000-01-02")
            param("firstName", "")
            param("lastName", "")
        }.andExpect { status().is4xxClientError }
    }
}
