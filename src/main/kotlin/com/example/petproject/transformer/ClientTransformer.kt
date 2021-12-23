package com.example.petproject.transformer

import com.example.petproject.model.Client
import com.example.petproject.model.dto.ClientDto
import com.example.petproject.repository.ClientRepository
import org.springframework.stereotype.Component

@Component
class ClientTransformer(
) {

    fun transform(preference: Client) = ClientDto(
        email = preference.email,
        password = preference.password,
        birthDate = preference.birthDate,
        firstName = preference.firstName,
        lastName = preference.lastName
    )

    fun transform(preference: ClientDto) = Client().apply {
        email = preference.email
        password = preference.password
        birthDate = preference.birthDate
        firstName = preference.firstName
        lastName = preference.lastName
    }
}
