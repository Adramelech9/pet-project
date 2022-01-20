package com.example.petproject.controller

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.service.ClientService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.util.ReflectionTestUtils.setField
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(ClientController::class)
internal class ClientControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @MockBean
    private lateinit var clientService: ClientService

    @Test
    fun `get client`() {
        mockMvc.get(Companion.path)
            .andExpect { status().isOk }
    }

    @Test
    fun `find client`() {
        mockMvc.get("${Companion.path}/e")
            .andExpect { status().isOk }
    }

    @ParameterizedTest
    @MethodSource("dto")
    fun `add new client`(dto: ClientDto, isValid: Boolean) {
        if (isValid) mockMvc.post(dto).andExpect(status().isOk)
        else mockMvc.post(dto).andExpect(status().is4xxClientError)
    }

    private fun MockMvc.post(dto: ClientDto): ResultActions =
        perform(
            MockMvcRequestBuilders.post(Companion.path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(dto))
        )

    private fun createValidDto() =
        ClientDto(
            email = "2@fmail.com",
            password = "123456",
            birthDate = LocalDate.of(2000, 2, 22),
            firstName = "name",
            lastName = "name"
        )

    private fun dto(): Stream<Arguments> =
        Stream.of(
            Arguments.of(createValidDto(), true),
            Arguments.of(createValidDto().apply {
                setField(this, "email", "123456")
            }, false),
            Arguments.of(createValidDto().apply {
                setField(this, "email", null)
            }, false),
            Arguments.of(createValidDto().apply {
                setField(this, "password", "")
            }, false),
            Arguments.of(createValidDto().apply {
                setField(this, "password", null)
            }, false),
            Arguments.of(createValidDto().apply {
                setField(this, "birthDate", LocalDate.of(2222, 2, 2))
            }, false),
            Arguments.of(createValidDto().apply {
                setField(this, "firstName", "a")
            }, false),
            Arguments.of(createValidDto().apply {
                setField(this, "lastName", "A")
            }, false)
        )

    companion object {

        const val path = "/api/clients"
    }
}
