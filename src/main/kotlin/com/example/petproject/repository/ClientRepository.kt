package com.example.petproject.repository

import com.example.petproject.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: JpaRepository<Client, Long> {

    @Query("select c.id, c.firstName, c.lastName from Client c")
    fun findAllName(): List<String>

    fun findClientById(id: Long): Client
}
