package com.example.petproject.repository

import com.example.petproject.model.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long>, ClientRepositoryCustom {
}
