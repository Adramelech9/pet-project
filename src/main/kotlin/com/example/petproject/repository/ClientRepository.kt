package com.example.petproject.repository

import com.example.petproject.model.Client
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: CrudRepository<Client, Long> {}