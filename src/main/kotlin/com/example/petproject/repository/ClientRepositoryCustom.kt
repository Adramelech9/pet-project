package com.example.petproject.repository

import com.example.petproject.model.dto.ShortClientDto

interface ClientRepositoryCustom {

    fun findShortClients(): List<ShortClientDto>
}
