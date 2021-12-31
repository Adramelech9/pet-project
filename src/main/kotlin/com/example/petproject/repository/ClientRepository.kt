package com.example.petproject.repository

import com.example.petproject.model.Client
import com.example.petproject.model.dto.ClientDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ClientRepository: JpaRepository<Client, Long> {

    @Query("select c.id, c.firstName, c.lastName from Client c")
    fun findName(): Optional<ClientDto>

    fun findClientById(id: Int): Optional<ClientDto>
}
