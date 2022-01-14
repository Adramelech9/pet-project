package com.example.petproject.repository

import com.example.petproject.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: JpaRepository<Client, Long> {
}
