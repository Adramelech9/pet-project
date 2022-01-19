package com.example.petproject.repository

import com.example.petproject.model.dto.ShortClientDto
import org.springframework.stereotype.Repository

@Repository
interface ClientRepositoryCustom {

    fun findShortClients(): List<ShortClientDto>
}
