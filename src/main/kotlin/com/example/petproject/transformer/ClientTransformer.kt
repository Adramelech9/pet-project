package com.example.petproject.transformer

import com.example.petproject.model.Client
import com.example.petproject.model.dto.ShortClientDto
import com.example.petproject.model.dto.ClientDto
import org.springframework.stereotype.Component

@Component
class ClientTransformer {

    fun transform(entity: Client) = ClientDto(
        email = entity.email,
        password = entity.password,
        birthDate = entity.birthDate,
        firstName = entity.firstName,
        lastName = entity.lastName
    )

    fun transform(dto: ClientDto) = Client().apply {
        email = dto.email
        password = dto.password
        birthDate = dto.birthDate
        firstName = dto.firstName
        lastName = dto.lastName
    }

    fun transformAllClients(entity: Client) = ShortClientDto(
        id = entity.id,
        firstName = entity.firstName,
        lastName = entity.lastName
    )
}
